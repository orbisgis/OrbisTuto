package org.orbisgis.tutorial.utils

abstract class TutorialScript extends Script {
    def random = new Random()

    def step = 1

    def maxStep = 9
    def minStep = 1

    void next(step) {
        if(step+1 <= maxStep) {
            load(step+1, "exercises")
        }
        else if (step+1 > maxStep) {
            println "You have reached the ending"
        }
    }

    void prev(step) {
        if(step-1 >= minStep) {
            load(step-1, "exercises")
        }
        else if (step-1 < minStep) {
            println "You have reached the beginning"
        }
    }

    void load(step, folder) {
        println "Load step $step"
        def destScript = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI())
        def srcScript = new File(
                new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParent(),
                "utils/$folder/step${step}.groovy")
        destScript.text = ''
        destScript << srcScript.text
                .replaceFirst("package org.orbisgis.tutorial.utils.exercises", "package org.orbisgis.tutorial")
                .replaceFirst("package org.orbisgis.tutorial.utils.solutions", "package org.orbisgis.tutorial")
    }

    void solve(step) {
        load(step, "solutions")
    }

    void init() {
        load(1, "exercises")
    }

    void stop() {
        System.exit(0)
    }

    def _genCtry

    String generateCountry() {
        i = Math.abs(random.nextInt())%4
        switch(i){
            case 0 :
                _genCtry = "France"
                break
            case 1 :
                _genCtry = "Allemagne"
                break
            case 2 :
                _genCtry = "Espagne"
                break
            case 3 :
                _genCtry = "Cambodge"
                break
        }
        return _genCtry
    }

    boolean check(answer){

        if ((_genCtry == 'France' && answer == 'Bonjour') ||
                (_genCtry == 'Allemagne' && answer == 'Hallo') ||
                (_genCtry == 'Espagne' && answer == 'Hola') ||
                (_genCtry == 'Cambodge' && answer == 'ជំរាបសួរ')){
            println answer
            return true
        }
        return false
    }


    void noParameterFunction(){
        println()
    }

    void oneParameterFunction(message){
        println(message)
    }

    void multipleParameterFunction(message, count){
        def i=0
        while (i<count){
            println(message)
            i++
        }
    }
}