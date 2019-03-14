package org.orbisgis.tutorial.utils.exercises

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

h2gis.load "../../../../../../resources/org/orbisgis/tutorial/Europe.shp", "europe", true
//h2gis.link "../../../../../../resources/org/orbisgis/tutorial/Europe.shp", "europe", true

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

H2GIS initH2gis(){
}

int[] getBox(H2GIS h2gis){
}

int[] getRandomPoint(int[] maxMin) {
}

void sayHello(country){
}

String getCountry(H2GIS h2gis){
}

sayHello(getCountry())


// Uncomment next line to go to the next step
// next step
// Or uncomment the next line to get the solution
// solve step