package org.orbisgis.tutorial.utils.solutions

import groovy.transform.BaseScript
import org.locationtech.jts.geom.Geometry
import org.orbisgis.datamanager.JdbcDataSource
import org.orbisgis.datamanager.h2gis.H2GIS
import org.orbisgis.datamanager.postgis.POSTGIS
import org.orbisgis.tutorial.utils.TutorialScript

@BaseScript TutorialScript tutorialScript

/**
 * Step 8 : Library DataManager
 */

step = 8

//Creation of a DataSource.

assert H2GIS.class.asSubclass(JdbcDataSource)
assert POSTGIS.class.asSubclass(JdbcDataSource)

h2gis = H2GIS.open"./tmp/h2gis"

// Load file

h2gis.load "utils/data/Europe.shp", "europe", true
//h2gis.link "utils/data/Europe.shp", "europe", true

// Request a simple table
europeTable = h2gis.getSpatialTable("europe")

//Display data from the table
println europeTable.name
println europeTable.columnNames

europeTable.eachRow {row -> println "Europe table content : ${row.getInt('PK')} ${row.getString('NAME')} ${row.getString('ORGN_NAME')}"}

//Request sub table
subTable = europeTable.limit(4)
subTable = h2gis.select"*" from "europe" limit 4

europeTable.columnNames.each {column -> print "$column\t\t"}
println()
subTable.eachRow {row ->
    println "${row.getInt('PK')}\t\t" +
            "${row.getString('THE_GEOM').substring(0, 10)}\t\t" +
            "${row.getString('NAME')}\t\t" +
            "${row.getString('ORGN_NAME')}\t\t"}

//TODO : The file 'Europe.shp' contains the geometry and the names of all the european countries.
//TODO : The file 'languages.csv' contains the 'hello' expression of each country.
//TODO : Generate a point, find out in which country the point is located and say hello in the good language


H2GIS initH2gis() {
    h2gis = H2GIS.open "./tmp/countries"
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

void sayHello(country){
    h2gis.select("HELLO").from("languages").where("COUNTRY ILIKE '$country'").eachRow {
        row -> println row.getObject(1)
    }
}


String getCountry(H2GIS h2gis) {
    def country = null
    println "Searching ..."
    while (country == null) {
        def pt = getRandomPoint(getBox(h2gis))
        country = null
        h2gis.select("*").from("europe").where("ST_Contains(THE_GEOM, ST_GeomFromText('POINT(${pt[0]} ${pt[1]})'))").eachRow {
            row -> country = row.getObject(3)
        }
        if (country == null) {
            println "Plouf !"
        } else {
            println country
        }
    }
    return country
}

sayHello(getCountry())


next step