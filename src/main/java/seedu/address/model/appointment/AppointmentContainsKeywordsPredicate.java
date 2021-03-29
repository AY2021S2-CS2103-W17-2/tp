package seedu.address.model.appointment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.person.Patient;
import seedu.address.ui.AppointmentListPanel;

/**
 * Tests that a {@code Appointment}'s {@code Prefix} matches any of the keywords given.
 */
public class AppointmentContainsKeywordsPredicate implements Predicate<Appointment> {
    private final List<String> patientList;
    private final List<String> doctorList;
    private final List<String> timeStartList;
    private final List<String> tagsList;

    /**
     * Constructor for Predicate
     *
     * @param patientList of keywords of patient names
     * @param doctorList of keywords of doctor names
     */
    public AppointmentContainsKeywordsPredicate(List<String> patientList, List<String> doctorList,
                                                List<String> timeStartList, List<String> tagsList) {
        this.patientList = patientList;
        this.doctorList = doctorList;
        this.tagsList = tagsList;
        this.timeStartList = timeStartList;
    }

    @Override
    public boolean test(Appointment appointment) {
        Map<UUID, Patient> patientHashMap = AppointmentListPanel.getPatientHashMap();

        Predicate<String> isMatchPatient = keyword -> StringUtil.containsWordIgnoreCase(
                patientHashMap.get(appointment.getPatientUuid())
                .getName().fullName, keyword);

        Predicate<String> isMatchDoctor = keyword -> StringUtil.containsWordIgnoreCase(appointment
                .getDoctor().getName().fullName, keyword);

        Predicate<String> isMatchTimeStart = keyword
            -> StringUtil.containsWordIgnoreCase(appointment.getAppointmentStart().toString()
                .replace("T", " "), keyword);

        Set<String> stringSet = appointment.convertToStringSet(appointment.getTags());
        String allTags = String.join(" ", stringSet);
        Predicate<String> isMatchTags = keyword -> StringUtil.containsWordIgnoreCase(allTags, keyword);

        Function<String, List<String>> patientNameSplitMapper = new Function<>() {
            @Override
            public List<String> apply(String patientName) {
                return Arrays.asList(patientName.split(" "));
            };
        };

        Predicate<List<String>> isMatchPatientName = keywords -> keywords.stream().anyMatch(isMatchPatient);

        return patientList.stream().map(patientNameSplitMapper).anyMatch(isMatchPatientName)
                || doctorList.stream().anyMatch(isMatchDoctor)
                || timeStartList.stream().anyMatch(isMatchTimeStart)
                || tagsList.stream().anyMatch(isMatchTags);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AppointmentContainsKeywordsPredicate
                && patientList.equals(((AppointmentContainsKeywordsPredicate) other).patientList)
                && doctorList.equals(((AppointmentContainsKeywordsPredicate) other).doctorList)
                && tagsList.equals(((AppointmentContainsKeywordsPredicate) other).tagsList));
    }

}
