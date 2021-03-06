package com.mauriciotogneri.greencoffeeexample.test.steps;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;
import com.mauriciotogneri.greencoffee.interactions.DataMatcher;
import com.mauriciotogneri.greencoffeeexample.R;
import com.mauriciotogneri.greencoffeeexample.model.Contact;
import com.mauriciotogneri.greencoffeeexample.test.matchers.ContactMatcher;

@SuppressWarnings("unused")
public class ContactListSteps extends GreenCoffeeSteps
{
    @When("^I select the contact called '([\\w| ]+)'$")
    public void iSelectTheContactCalled$(String username)
    {
        DataMatcher<Contact, String> dataMatcher = new ContactMatcher(R.id.contacts_list);
        dataMatcher.with(username).click();
    }

    @Then("^I see an empty contact list$")
    public void iSeeAnEmptyContactList()
    {
        onViewWithText(R.string.contacts_emptyList).isDisplayed();
    }

    @Then("^I see the contacts screen$")
    public void iSeeTheContactsScreen()
    {
        onViewWithText(R.string.contacts_title).isDisplayed();
    }
}