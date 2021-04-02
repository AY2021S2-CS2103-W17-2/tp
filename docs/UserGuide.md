---
layout: page
title: User Guide
---

App-Ointment is a desktop app for for managing and scheduling patient appointments, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, App-Ointment can get your contact management tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `App-Ointment.jar` from [here](https://github.com/AY2021S2-CS2103-W17-2/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your App-Ointment App.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list=appt`** : Lists all appointments in the appointment schedule.

   * **`add-patient`** `n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a patient.

   * **`delete-appt`** `3` : Deletes the 3rd displayed appointment.

   * **`clear-appt`** : Clears all appointments in the appointment schedule

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

<br>

### *Patient Commands*:

### Adding a patient: `add-patient`

Adds a patient to the patient records.<br>

Format: `add-patient n/NAME p/PHONE e/EMAIL a/ADDRESS [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: <b>Tip:</b>

* The patient can have any number of tags (including 0).<br>

</div><br>

Examples:

* `add-patient n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`

### Cleaning all entries in patient records: `clear-patient`
Clears all entries from the patient records. <br>
If appointments containing the patient to be deleted exists in the appointment schedule, then `--force` will have to be specified, to delete the relevant appointments as well.

Format: `clear-patient [--force]`

### Deleting a patient : `delete-patient`
Deletes the specified patient from the patient records.

Format: `delete-patient INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed patient records.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list-patient` followed by `delete-patient 2` deletes the 2nd patient in the patient records.
* `find-patient Betsy` followed by `delete-patient 1` deletes the 1st patient in the results of the `find-patient` command.

### Editing a patient : `edit-patient`
Edits an existing patient in the schedule.<br>

Format: `edit-patient INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* Edits the patient at the specified INDEX. The index refers to the index number shown in the displayed appointment schedule list. The index must be a <strong>positive integer</strong> 1, 2, 3, …​<br>

* At least one of the optional fields must be provided.<br>

* Existing values will be updated to the input values.<br>

* When editing tags, the existing tags of the patient will be removed i.e adding of tags is not cumulative.<br>

* You can remove all the patient’s tags by typing t/ without specifying any tags after it.<br>

* Raises an exception if there are conflicts in the new schedule for the patient and the doctor.<br>

Examples:

* `edit-patient 1 e/newEmail@example.com` Edits the 1st patient's email to newEmail@example.com.

* `edit-patient 2 n/Betsy Crower t/` Edits the name of patient under the 2nd appointment to be Betsy Crower and clears all existing tags.

### Locating patients by name: `find-patient`

Finds patients whose names contain any of the given keywords.

Format: `find-patient KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find-patient John` returns `john` and `John Doe`
* `find-patient bernice david` returns `Bernice Yu`, `David Li`<br>
  ![result for 'find bernice david'](images/findPatientBerniceDavidResult.png)


### Listing all patients : `list-patient`

Changes the displayed patient records to show all patients in the patient records.<br>

Format: `list-patient`

<br>

### *Doctor Commands*:

### Adding a doctor: `add-doctor`

Adds a doctor to the doctor records.<br>

Format: `add-doctor n/NAME [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: <b>Tip:</b>

* The doctor can have any number of tags (including 0).<br>

</div><br>

Examples:

* `add-doctor n/Dr Meredith Grey`

* `add-doctor n/Dr Strange t/Dormammu t/IveComeToBargain`


### Cleaning all entries in doctor records: `clear-doctor`
Clears all entries from the doctor records. <br>
If appointments containing the doctor to be deleted exists in the appointment schedule, then `--force` will have to be specified, to delete the relevant appointments as well.

Format: `clear-doctor [--force]`

### Deleting a doctor : `delete-doctor`
Deletes the specified doctor from the doctor records.

Format: `delete-doctor INDEX`

Similar to `delete-patient`

### Editing a doctor : `edit-doctor`
Edits an existing doctor in the doctor records.<br>

Format: `edit-doctor INDEX [n/NAME] [t/TAG]…​`

* Edits the doctor at the specified INDEX. The index refers to the index number shown in the displayed doctor records. The index must be a <strong>positive integer</strong> 1, 2, 3, …​<br>

Similar to `edit-patient`, except that there are less fields that are editable.

Examples:

* `edit-doctor 1 n/Dr Amy` Edits the 1st doctor's name to Dr Amy.

* `edit-doctor 2 n/Dr Betsy Crower t/` Edits the name of doctor under the 2nd displayed doctor record to be Betsy Crower and clears all existing tags.

### Locating doctors by name: `find-doctor`

Finds doctors in the doctor records whose names contain any of the given keywords.

Format: `find-doctor KEYWORD [MORE_KEYWORDS]`

Similar to `find-patient`

### Listing all doctors : `list-doctor`
Changes the displayed doctor records to show all doctors in the doctor records.<br>

Format: `list-doctor`

<br>

### *Appointment Commands*:

### Adding an appointment: `add-appt`

Adds an appointment to the schedule.<br>

Format: `add-appt pt/PATIENT_INDEX dr/DOCTOR_INDEX at/TIMESLOT_START [to/TIMESLOT_END] [dur/TIMESLOT_DURATION] [t/TAG]…​`

* The `PATIENT_INDEX` corresponds to the patient at the index number in the current displayed patient records.<br>

* The `DOCTOR_INDEX` corresponds to the doctor at the index number in the current displayed doctor records.<br>

* The `PATIENT_INDEX` and `DOCTOR_INDEX` must be a <strong>positive integer</strong> 1, 2, 3, …​<br>

* The `TIMESLOT_START` and `TIMESLOT_END` must be either in a recognisable datetime format or prefixed with keyword `NEXT` followed by a datetime unit (DAY, MONTH, YEAR) or weekday (MONDAY, TUESDAY …​)<br>

* Either and only one, `TIMESLOT_END` or `TIMESLOT_DURATION`, must be provided.<br>

* Raises an exception if there are conflicts in schedule for the patient or the doctor.<br>

<div markdown="span" class="alert alert-primary">:bulb: <b>Tip:</b>

* The appointment can have any number of tags (including 0). It is recommended to use the tags to define the purpose of the appointment.<br>

</div><br>

Examples:

* `add-appt pt/1 dr/3 at/2021-01-01 00:00 to/2021-01-01 01:30 t/severe t/brainDamage`

* `add-appt pt/2 dr/2 at/2021-01-01 00:00 dur/1H 30M t/exhaustion`

* `add-appt pt/3 dr/1 at/NEXT MONDAY dur/1H 30M`

### Cleaning all entries in appointment schedule: `clear-appt`
Clears all entries from the appointment schedule.<br>

Format: `clear-appt`


### Deleting an appointment : `delete=appt`
[Coming Soon]

Deletes the specified appointment from the schedule.

Format: `delete-appt INDEX`

* Deletes the appointment at the specified INDEX.

* The index refers to the index number shown in the displayed appointment list.

* The index must be a <strong>positive integer</strong> 1, 2, 3, …​

Examples:

* `list-appt` followed by `delete-appt 2` deletes the 2nd appointment in the entire appointment schedule.

* `find-appt Betsy` followed by `delete-appt 1 ` deletes the 1st appointment in the results of the `find` command.


### Editing an appointment : `edit-appt`
[Coming Soon]

Edits an existing appointment in the appointment schedule.<br>

Format: `edit-appt APPOINTMENT_INDEX [pt/PATIENT_INDEX] [dr/DOCTOR_INDEX] [at/TIMESLOT START] [to/TIMESLOT END] [dur/TIMESLOT DURATION] [t/TAG]…​`

* Edits the appointment for the patient specified by the `APPOINTMENT_INDEX`.  The `APPOINTMENT_INDEX` refers to the index number shown in the displayed appointment schedule. The index must be a <strong>positive integer</strong> 1, 2, 3, …​<br>

* At least one of the optional fields must be provided <br>

* Existing values will be updated to the input values.<br>

* When editing tags, the existing tags of the appointment will be removed i.e adding of tags is not cumulative.<br>

* You can remove all the person’s tags by typing t/ without specifying any tags after it.<br>

* Raises an exception if there are conflicts in the new appointment with the existing appointments.<br>

Examples:

* `edit-appt 1 pt/1 dr/2` Edits the appointment at index 1 to assign the patient at index 1 and doctor at index 2.

* `edit-appt 2 at/2021-05-08 09:00 dur/1H t/severe t/fever` Edits the appointment at index 2 to assign a timeslot at 8 May 2021 9AM for a duration of 1 hour and tag the appointment with severe and fever tags.


### Locating appointments by fields : `find-appt`
[Coming Soon]

Format: `find-appt [n/PATIENT KEYWORDS] [dr/DOCTOR_KEYWORDS] [d/DATETIME] [p/PHONE] [e/EMAIL] [a/ADDRESS_KEYWORDS] [t/TAG KEYWORDS]`

* At least one of the optional fields must be provided.<br>

* The search is case-insensitive. e.g `hans` will match `Hans`<br>

* Only full words will be matched. e.g. `han` will not match `Hans`<br>

* Search fields require at least one keyword to be matched in the field description for the search condition of that field to be satisfied. e.g. `find n/Hans Bo` will match both patients `Hans Gruber` and `Bo Young`.

* Certain fields such as datetime, phone number and email do not support a search by keywords and require a match with the entire field description for the search condition to be satisfied.

* Where multiple search fields are specified, the search is conditioned on the satisfaction of <strong>all</strong> of the search fields' subconditions. e.g. `find n/Hans Bo dr/Grey` will match appointments that satisfy both:
  - Grey in the assigned doctor's name; and
  - Either Hans or Bo in the patient's name.

Examples:

* `find-appt n/john alex` returns appointments with patients `john`, `John`, `John Doe`, `alex`, `Alex` and `Alex Anderson`.

* `find-appt dr/Grey Who t/BrainSurgery` returns appointments with doctors `grey` or `who` and are tagged as `BrainSurgery`.


### Listing all appointments : `list-appt`

Changes the displayed appointment list to show all appointments in the appointment schedule.<br>

Format: `list-appt`


### *Overall Commands*

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Viewing help: `help`
[Coming soon]

Format: `help`

Showing a message containing the url to the User Guide page

### Saving the data

App-Ointment data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

App-Ointment data are saved as 3 JSON files:
`[JAR file location]/data/PatientRecords.json`
`[JAR file location]/data/DoctorRecords.json`
`[JAR file location]/data/AppointmentSchedule.json`
Advanced users are welcome to update data directly by editing the data files.
Do note that adding entries into the patient and doctor records will require a UUID Version 4 generator.

<div markdown="span" class="alert alert-warning">:exclamation: <b>Caution:</b>
If your changes to the data files makes its format invalid, App-Ointment will discard the data file that is invalid and start with an empty data file at the next run.
</div><br>

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous App-Ointment home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action            | Format                                  | Examples                                           |
|-------------------|-----------------------------------------|----------------------------------------------------|
| **add-patient** | `add-patient n/NAME p/PHONE e/EMAIL a/ADDRESS [t/TAG]…​` | `add-patient n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` |
| **clear-patient** | `clear-patient [--force]` | |
| **delete-patient** | `delete-patient INDEX` | `delete-patient 2` |
| **edit-patient** | `edit-patient INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​` | `edit-patient 1 e/newEmail@example.com`<br> `edit-patient 2 n/Betsy Crower t/` |
| **find-patient** | `find KEYWORD [MORE_KEYWORDS]` | `find John`<br>`find bernice david` |
| **list-patient** | `list-patient` | |
| **add-doctor** | `add-doctor n/NAME [t/TAG]…​` | `add-doctor n/Dr John Doe` |
| **clear-doctor** | `clear-doctor [--force]` | |
| **delete-doctor** | `delete-doctor INDEX` | `delete-doctor 2` |
| **edit-doctor** | `edit-doctor INDEX [n/NAME] [t/TAG]…​` | `edit-doctor 1 n/Dr Amy`<br>`edit-doctor 2 n/Dr Betsy Crower t/` |
| **find-doctor** | `find-doctor KEYWORD [MORE_KEYWORDS]` | `find Amy`<br>`find Amy Betsy` |
| **list-doctor** | `list-doctor` | |
| **add-appt** | `add-appt pt/PATIENT_INDEX dr/DOCTOR_INDEX at/TIMESLOT_START [to/TIMESLOT_END] [dur/TIMESLOT_DURATION] [t/TAG]…​` | `add-appt pt/1 dr/1 at/2021-01-01 00:00 to/2021-01-01 01:30 t/severe t/brainDamage`<br>`add-appt pt/2 dr/2 at/2021-01-01 00:00 dur/1H 30M t/exhaustion`<br>`add-appt pt/3 dr/3 at/NEXT MONDAY dur/1H 30M` |
| **clear-appt** | `clear-appt` | |
| **delete-appt** | `delete-appt INDEX` | `delete-appt 2` |
| **edit-appt** | `edit-appt APPOINTMENT_INDEX [pt/PATIENT_INDEX] [dr/DOCTOR_INDEX] [at/TIMESLOT_START] [to/TIMESLOT_END] [dur/TIMESLOT_DURATION] [t/TAG]…​` | `edit-appt 1 pt/1 dr/1`<br>`edit-appt 2 at/2021-05-08 09:00 dur/1H t/severe t/fever` |
| **find-appt** | `find [n/PATIENT KEYWORDS] [dr/DOCTOR_KEYWORDS] [d/DATETIME] [p/PHONE] [e/EMAIL] [a/ADDRESS_KEYWORDS] [t/TAG KEYWORDS]` | `find n/john alex`<br>`find dr/Grey Who t/BrainSurgery` |
| **list-appt** | `list-appt` | |
| **exit** | `exit` | |
| **help** | `help` | |
