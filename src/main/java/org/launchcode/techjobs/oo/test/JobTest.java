package org.launchcode.techjobs.oo.test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobA = new Job();
        Job jobB = new Job();

        assertNotEquals(jobA.getId(), jobB.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                          new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester" , job.getName());
        assertEquals("ACME" , job.getEmployer().getValue());
        assertEquals("Desert" , job.getLocation().getValue() );
        assertEquals("Quality control" , job.getPositionType().getValue());
        assertEquals("Persistence" , job.getCoreCompetency().getValue() );
    }


    @Test
    public void testJobsForEquality() {
        Job jobA = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobB = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(!jobA.equals(jobB));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals('\n', job.toString().charAt(0));
        assertEquals('\n', job.toString().charAt(job.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.toString().contains(String.format("ID: %s", job.getId())));
        assertTrue(job.toString().contains("Employer: ACME"));
        assertTrue(job.toString().contains("Location: Desert"));
        assertTrue(job.toString().contains("Position Type: Quality control"));
        assertTrue(job.toString().contains("Core Competency: Persistence"));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job();
        job.setEmployer(new Employer("ACME"));
        job.setLocation(new Location("Desert"));
        job.setPositionType(new PositionType("Quality control"));

        assertTrue(job.toString().contains("Core Competency: Data not available"));
    }

    @Test
    public void testToStringHandlesJobDoesNotExist() {
        Job job = new Job();

        assertTrue(job.toString().contains("OOPS! This job does not seem to exist."));
    }
}
