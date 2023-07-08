# FutureBuilder
AP_Assignment1

The application needs to serve the following requirements:-

1) The placement cell opens company registrations, following which students register for companies they are interested in.
2) A student can register for a company if they meet the following criteria -
        a) If not placed yet and is eligible.
        b) CGPA of the student >= minimum CGPA criteria of the company
        c) CTC offered by the company >= 3 * highest CTC currently held by the student
3) Once the company receives all the registrations, it selects some students out of the ones who applied (a company has to select at least one student; students can 
   be picked randomly for this question).
4) The selected students have the option to accept or reject the offer.
5) If a student accepts an offer, the status of that student should be marked as offered and should not be allowed to sit in any further processes (unless the 
   student satisfies criteria 2(b) and 2(c)).
6) If a not yet placed student rejects all the available offers at any point, then the student status should be marked as blocked and shouldn’t be allowed to 
    participate further.
7) A company can register only once.
