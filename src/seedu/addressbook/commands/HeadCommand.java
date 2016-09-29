package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.List;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class HeadCommand extends Command{
	public static final String COMMAND_WORD = "head";
	public static final int HEAD_VALUE = 10;
	public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Displays first 10 persons in the address book as a list with index numbers.\n\t"
            + "Example: " + COMMAND_WORD;
	public void Head(ArrayList<ReadOnlyPerson> x, int y)
	{
		int size = x.size();
		if(size > y){
			for(int i = y; i < size; i++)
			{
				x.remove(i);
			}
			
		}
		
	}
	@Override
	public CommandResult execute() {
        ArrayList<ReadOnlyPerson> allPersons = new ArrayList(addressBook.getAllPersons().immutableListView());
        Head(allPersons, HEAD_VALUE);
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
