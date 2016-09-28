package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's website in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidWebsite(String)}
 */
public class Website {

    public static final String EXAMPLE = "https://websi.te/user#portfolio";
    public static final String MESSAGE_WEBSITE_CONSTRAINTS =
            "Person websites should start with http:// or https:// followed by alphanumeric/period strings that can include +&@#/%?=~_|!:,.; but only ends with an alphanumeric or +&@#/%=~_| character ";
    public static final String WEBSITE_VALIDATION_REGEX = "\\bhttps?://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given website.
     *
     * @throws IllegalValueException if given website address string is invalid.
     */
    public Website(String website, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        website = website.trim();
        if (!isValidWebsite(website)) {
            throw new IllegalValueException(MESSAGE_WEBSITE_CONSTRAINTS);
        }
        this.value = website;
    }

    /**
     * Checks if a given string is a valid person website.
     */
    public static boolean isValidWebsite(String test) {
        return test.matches(WEBSITE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Website // instanceof handles nulls
                && this.value.equals(((Website) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}