package seedu.addressbook.commands;

import java.util.HashSet;
import java.util.Set;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.commands.AddCommand;

public class EditCommand extends Command {
	public static final String COMMAND_WORD = "edit";
	
	public static final String MESSAGE_SUCCESS = "Information edited: %1$s";
	
	private String keyword;
	
	private final Person toEdit;
	
//	public EditCommand(int targetVisibleIndex, String keyword) {
//        super(targetVisibleIndex);
//        
//        this.keyword = keyword;
//        
//        this.toEdit = new Person(
//        		new Name(name),
//        		new Phone(phone, isPhonePrivate),
//        		new Email(email, isEmailPrivate),
//        		new Address(address, isAddressPrivate),
//        		new UniqueTagList(tagSet)
//        );
//    }
	
	
	public EditCommand(int targetVisibleIndex, String keyword, Person toEdit){
		super(targetVisibleIndex);
		this.keyword = keyword;
		this.toEdit = toEdit;
	}
	
	
//	public EditCommand(Person toEdit){
//		this.toEdit = toEdit;
//	}
	
	
	public Person editInformation(String key, Person toEdit) throws IllegalValueException{
	String result="invalid";
	switch(key){
	        case ".+": 
	        	String newAddress = key;
	        	boolean newAAdress = toEdit.getAddress().isPrivate();
	        	String newEmail = toEdit.getEmail().toString();
	        	boolean newEEmail = toEdit.getEmail().isPrivate();
	        	String newName = toEdit.getName().toString();
	        	String newPhone = toEdit.getPhone().toString();
	        	boolean newPPhone = toEdit.getPhone().isPrivate();
	        	
	        	
	        	toEdit = new Person(new Name(newName), new Phone(newPhone, newPPhone), new Email(newEmail, newEEmail), new Address(newAddress, newAAdress), toEdit.getTags());
	        	//addressBook.addPerson(toEdit);
                return toEdit;
	        	
//	        case 2: key = "[\\w\\.]+@[\\w\\.]+";
//	        break;
//	        case 3: key = "[\\p{Alnum} ]+";
//	        break;
//	        case 4: key = "\\d+";
//	        break;
         
                
	}
	return toEdit;
	}
	
	public ReadOnlyPerson getPerson() {
        return toEdit;
    }
	
		
	@Override
    public CommandResult execute() {
        try {
            final ReadOnlyPerson target = getTargetPerson();
        	addressBook.addPerson(editInformation(keyword, toEdit));
       
            addressBook.removePerson(target);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toEdit));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }
    }	
	

}
