package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.AppointmentSchedule;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.appointment.Timeslot;
import seedu.address.model.person.Doctor;
import seedu.address.model.person.Patient;

/**
 * A utility class containing a list of {@code Patient}, {@code Doctor},
 * and {@code Timeslot}, and {@code Appointment} objects to be used in tests.
 */
public class TypicalAppObjects {

    public static final Patient ALICE = new PatientBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253")
            .withTags("friends").build();
    public static final Patient BENSON = new PatientBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withTags("owesMoney", "friends").build();
    public static final Patient CARL = new PatientBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("wall street").build();
    public static final Patient DANIEL = new PatientBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street").withTags("friends").build();
    public static final Patient ELLE = new PatientBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave").build();
    public static final Patient FIONA = new PatientBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo").build();
    public static final Patient GEORGE = new PatientBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withAddress("4th street").build();

    // Manually added
    public static final Patient HOON = new PatientBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withAddress("little india").build();
    public static final Patient IDA = new PatientBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Patient AMY = new PatientBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Patient BOB = new PatientBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    // Manually added - Doctor details
    public static final Doctor DR_GREY = new DoctorBuilder()
            .withName("Dr Meredith Grey").withTags("GreysAnatomy").build();
    public static final Doctor DR_WHO = new DoctorBuilder()
            .withName("Dr Who").withTags("DoctorWho", "TimeLord").build();
    public static final Doctor DR_STRANGE = new DoctorBuilder().withName("Dr Strange").build();
    public static final Doctor DR_JEKYLL = new DoctorBuilder()
            .withName("Dr Jekyll").withTags("AndMrHyde").build();
    public static final Doctor DR_MURPHY = new DoctorBuilder().withName("Dr Murphy").build();
    public static final Doctor DR_DRAKE = new DoctorBuilder().withName("Dr Drake Ramoray").build();

    // Manually added - Timeslot details
    public static final Duration APPOINTMENT_DURATION = Duration.ofHours(1);
    public static final Timeslot TIMESLOT_1HOUR_8AM = new Timeslot(
            LocalDateTime.of(2021, 1, 1, 8, 0, 0), APPOINTMENT_DURATION);
    public static final Timeslot TIMESLOT_1HOUR_9AM = new Timeslot(
            LocalDateTime.of(2021, 1, 1, 9, 0, 0), APPOINTMENT_DURATION);
    public static final Timeslot TIMESLOT_1HOUR_10AM = new Timeslot(
            LocalDateTime.of(2021, 1, 1, 10, 0, 0), APPOINTMENT_DURATION);
    public static final Timeslot TIMESLOT_1HOUR_11AM = new Timeslot(
            LocalDateTime.of(2021, 1, 1, 11, 0, 0), APPOINTMENT_DURATION);
    public static final Timeslot TIMESLOT_1HOUR_12PM = new Timeslot(
            LocalDateTime.of(2021, 1, 1, 12, 0, 0), APPOINTMENT_DURATION);
    public static final Timeslot TIMESLOT_1HOUR_1PM = new Timeslot(
            LocalDateTime.of(2021, 1, 1, 13, 0, 0), APPOINTMENT_DURATION);
    public static final Timeslot TIMESLOT_1HOUR_2PM = new Timeslot(
            LocalDateTime.of(2021, 1, 1, 14, 0, 0), APPOINTMENT_DURATION);

    // Alice should not have an appointment for DeletePatientCommandTest to test
    public static final Appointment BENSON_DR_GREY = new AppointmentBuilder()
            .withPatient(BENSON).withDoctor(DR_GREY).withTimeslot(TIMESLOT_1HOUR_9AM).build();
    public static final Appointment CARL_DR_WHO = new AppointmentBuilder()
            .withPatient(CARL).withDoctor(DR_WHO).withTimeslot(TIMESLOT_1HOUR_10AM).build();
    public static final Appointment DANIEL_DR_STRANGE = new AppointmentBuilder()
            .withPatient(DANIEL).withDoctor(DR_STRANGE).withTimeslot(TIMESLOT_1HOUR_11AM).build();
    public static final Appointment ELLE_DR_JEKYLL = new AppointmentBuilder()
            .withPatient(ELLE).withDoctor(DR_JEKYLL).withTimeslot(TIMESLOT_1HOUR_12PM).build();
    public static final Appointment FIONA_DR_MURPHY = new AppointmentBuilder()
            .withPatient(FIONA).withDoctor(DR_MURPHY).withTimeslot(TIMESLOT_1HOUR_1PM).build();
    public static final Appointment GEORGE_DR_DRAKE = new AppointmentBuilder()
            .withPatient(GEORGE).withDoctor(DR_DRAKE).withTimeslot(TIMESLOT_1HOUR_2PM).build();

    private TypicalAppObjects() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical patients.
     */
    public static AddressBook<Patient> getTypicalPatientRecords() {
        AddressBook<Patient> patientRecords = new AddressBook<>();
        for (Patient patient : getTypicalPatients()) {
            patientRecords.addPerson(patient);
        }
        return patientRecords;
    }

    public static List<Patient> getTypicalPatients() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }

    public static AppointmentSchedule getEmptyAppointmentSchedule() {
        AppointmentSchedule as = new AppointmentSchedule();
        return as;
    }

    /**
     * Returns an {@code AddressBook} with all the typical patients.
     */
    public static AddressBook<Doctor> getTypicalDoctorRecords() {
        AddressBook<Doctor> doctorRecords = new AddressBook<>();
        for (Doctor doctor : getTypicalDoctors()) {
            doctorRecords.addPerson(doctor);
        }
        return doctorRecords;
    }

    public static List<Doctor> getTypicalDoctors() {
        return new ArrayList<>(Arrays.asList(DR_GREY, DR_WHO, DR_STRANGE, DR_JEKYLL, DR_MURPHY, DR_DRAKE));
    }

    /**
     * Returns an {@code AppointmentSchedule} with all the typical appointments.
     */
    public static AppointmentSchedule getTypicalAppointmentSchedule() {
        AppointmentSchedule as = new AppointmentSchedule();
        for (Appointment appointment : getTypicalAppointments()) {
            as.addAppointment(appointment);
        }
        return as;
    }

    public static List<Appointment> getTypicalAppointments() {
        return new ArrayList<>(Arrays.asList(BENSON_DR_GREY, CARL_DR_WHO, DANIEL_DR_STRANGE, ELLE_DR_JEKYLL,
                FIONA_DR_MURPHY, GEORGE_DR_DRAKE));
    }
}
