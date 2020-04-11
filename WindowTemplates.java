public class WindowTemplates extends Window {

    public WindowTemplates(String incidentType){
        if(incidentType == "Weather Alert"){
            setDisplayBehavior(new DisplayWeatherAlert());
        }else if (incidentType == "Burglary"){
            setDisplayBehavior(new DisplayBurglary());
        }else if (incidentType == "Suspicious Activity"){
            setDisplayBehavior(new DisplaySuspiciousActivity());
        }else if (incidentType == "Template 4"){

        }else if (incidentType == "Template 5"){

        }else if (incidentType == "Template 6"){

    }

    }

    public void display(){

    }
}
