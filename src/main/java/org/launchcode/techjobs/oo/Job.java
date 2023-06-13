package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name = "";
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();

        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }


    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public String toString() {
        String jobInfo = "\n";

        if (employer == null && location == null && positionType == null && coreCompetency == null) {
            return "OOPS! This job does not seem to exist.";
        }

        if (employer == null || employer.getValue() == "") this.employer = new Employer("Data not available");
        if (location == null || location.getValue() == "") this.location = new Location("Data not available");
        if (positionType == null || positionType.getValue() == "") this.positionType = new PositionType("Data not available");
        if (coreCompetency == null || coreCompetency.getValue() == "") this.coreCompetency = new CoreCompetency("Data not available");

        jobInfo = jobInfo.concat(String.format("ID: %s\n", id));
        jobInfo = jobInfo.concat(String.format("Name: %s\n", name));
        jobInfo = jobInfo.concat(String.format("Employer: %s\n", employer));
        jobInfo = jobInfo.concat(String.format("Location: %s\n", location));
        jobInfo = jobInfo.concat(String.format("Position Type: %s\n", positionType));
        jobInfo = jobInfo.concat(String.format("Core Competency: %s\n", coreCompetency));

        //jobInfo = jobInfo.concat("\n");
        return jobInfo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(!(obj instanceof Job)) return false;
        Job job = (Job) obj;
        return this.getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setName(String name) {
        this.name = name;
    }
}
