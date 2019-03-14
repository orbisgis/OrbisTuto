package org.orbisgis.tutorial.utils.solutions

import groovy.transform.BaseScript
import org.locationtech.jts.geom.Geometry
import org.orbisgis.datamanager.JdbcDataSource
import org.orbisgis.datamanager.h2gis.H2GIS
import org.orbisgis.datamanager.postgis.POSTGIS
import org.orbisgis.processmanager.ProcessManager
import org.orbisgis.processmanager.ProcessMapper
import org.orbisgis.tutorial.utils.TutorialScript

@BaseScript TutorialScript tutorialScript

/**
 * Step 9 : Library ProcessManager
 */

step = 9

//First thing : get a process factory which will be used to create processes

factory = ProcessManager.createFactory("learnGroovy")

//Then create a process
process = factory.create("title",
        [inputA : String, inputB : String],
        [outputA : String, outputB : String],
        { inputA, inputB ->
            def str1 = inputA + inputB
            def str2 = inputB + inputA
            [outputB: str1, outputA: str2]
        })
//Execute the process
process.execute([inputA: "tata", inputB: "toto"])
//Get the results
process.results.each {
    result -> println result.value
}

//TODO

H2GIS initH2GIS() {
    def h2gis = H2GIS.open "./tmp/countries"
    h2gis.load "utils/data/Europe.shp", "europe", true
    h2gis.load "utils/data/languages.csv", "languages", true
    return h2gis
}

processInit = factory.create('initH2GIS', [h2gisOut : H2GIS], {
    def h2gis = H2GIS.open "./tmp/countries"
    h2gis.load "utils/data/Europe.shp", "europe", true
    h2gis.load "utils/data/languages.csv", "languages", true
    [h2gisOut : h2gis]
})
processInit.execute()
processInit.results.each {result -> println result}

int[] getBox(H2GIS h2gis){
    int[] array = null
    h2gis.select "ST_XMax(ST_Envelope(ST_Accum(THE_GEOM))), " +
            "ST_XMin(ST_Envelope(ST_Accum(THE_GEOM))), " +
            "ST_YMax(ST_Envelope(ST_Accum(THE_GEOM))), " +
            "ST_YMin(ST_Envelope(ST_Accum(THE_GEOM)))" from "europe" eachRow {
        row -> array = [row.getInt(1), row.getInt(2), row.getInt(3), row.getInt(4)]
    }
    return array
}

processGetBox = factory.create('getBox', [h2gis : H2GIS], [coordinatesOut : int[]], { h2gis ->
    int[] array = null
    h2gis.select "ST_XMax(ST_Envelope(ST_Accum(THE_GEOM))), " +
            "ST_XMin(ST_Envelope(ST_Accum(THE_GEOM))), " +
            "ST_YMax(ST_Envelope(ST_Accum(THE_GEOM))), " +
            "ST_YMin(ST_Envelope(ST_Accum(THE_GEOM)))" from "europe" eachRow {
        row -> array = [row.getInt(1), row.getInt(2), row.getInt(3), row.getInt(4)]
    }
    [coordinatesOut: array]
})

int[] getRandomPoint(int[] maxMin) {
    def rd = new Random()
    return [rd.nextInt() % (maxMin[0] - maxMin[1]) + maxMin[1],
            rd.nextInt() % (maxMin[2] - maxMin[3]) + maxMin[3]]
}

processGetRandomPoint = factory.create('getRandomPoint', [coordinates : int[]], [pointOut : int[]], { int[] coordinates ->
    def rd = new Random()
    int[] pt = [rd.nextInt() % (coordinates[0] - coordinates[1]) + coordinates[1],
            rd.nextInt() % (coordinates[2] - coordinates[3]) + coordinates[3]]
    [pointOut: pt]
})

String sayHello(String country, H2GIS h2gis){
    def hello = ""
    h2gis.select("HELLO").from("languages").where("COUNTRY ILIKE '$country'").eachRow {
        row -> hello = row.getObject(1)
    }
    return hello
}

processSayHello = factory.create('sayHello', [country : String, h2gis : H2GIS], [helloOut : String],
        { String country, H2GIS h2gis ->
            def str = ""
            h2gis.select("HELLO").from("languages").where("COUNTRY ILIKE '$country'").eachRow {
                row -> str = row.getObject(1)
            }
            [helloOut : str]
        }
)

String searchCountry(H2GIS h2gis, int[] pt) {
    def country = null
    println "Searching ..."
    while (country == null) {
        country = null
        h2gis.select("*").from("europe").where("ST_Contains(THE_GEOM, ST_GeomFromText('POINT(${pt[0]} ${pt[1]})'))").eachRow {
            row -> country = row.getObject(3)
        }
        if (country == null) {
            println "Plouf !"
        } else {
            println country
            return country
        }
    }
}

processSearchCountry = factory.create('searchCountry', [h2gis : H2GIS, 'pt' : int[]], [countryOut : String],
        {H2GIS h2gis, int[] pt ->
            def country = null
            country = null
            h2gis.select("*").from("europe").where("ST_Contains(THE_GEOM, ST_GeomFromText('POINT(${pt[0]} ${pt[1]})'))").eachRow {
                row -> country = row.getObject(3)
            }
            if (country == null) {
                println "Plouf !"
            }
            [countryOut : country]
        }
)

def mapper = new ProcessMapper([
        [h2gisOut : processInit, h2gis : processGetBox],
        [coordinatesOut : processGetBox, coordinates : processGetRandomPoint],
        [h2gisOut : processInit, h2gis : processSearchCountry], [pointOut : processGetRandomPoint, pt : processSearchCountry],
        [h2gisOut : processInit, h2gis : processSayHello], [countryOut : processSearchCountry, country : processSayHello]
])

while(true) {
    mapper.execute()
    mapper.results.each { result -> if(!result.value.isEmpty()){println result.value} }
}





// Uncomment next line to go to the next step
// next step
// Or uncomment the next line to get the solution
// solve step