package org.orbisgis.tutorial.utils.exercises

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


//Then create a process


//Execute the process


//Get the results


stop()

//TODO : Package the functions of the previous step into processes, link them and execute the mapping.

H2GIS initH2GIS() {
    def h2gis = H2GIS.open "./tmp/countries"
    h2gis.load "utils/data/Europe.shp", "europe", true
    h2gis.load "utils/data/languages.csv", "languages", true
    return h2gis
}

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

int[] getRandomPoint(int[] maxMin) {
    def rd = new Random()
    return [rd.nextInt() % (maxMin[0] - maxMin[1]) + maxMin[1],
            rd.nextInt() % (maxMin[2] - maxMin[3]) + maxMin[3]]
}

String sayHello(String country, H2GIS h2gis){
    def hello = ""
    h2gis.select("HELLO").from("languages").where("COUNTRY ILIKE '$country'").eachRow {
        row -> hello = row.getObject(1)
    }
    return hello
}

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





// Uncomment next line to go to the next step
// next step
// Or uncomment the next line to get the solution
// solve step