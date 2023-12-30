package com.Amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.action.Action;
import com.Amazon.base.BaseClass;

public class HomePage extends  Action{
	 	
	BaseClass baseObj = null; 
	Action actionObj = new Action();
	
	@FindBy(xpath ="//div//span[@id='nav-search-label-id']") 
	 public WebElement dropdownValue;
	
	@FindBy(xpath = "//div[@id='nav-search-dropdown-card']")
	public WebElement dropdownlist;
	
	@FindBy(id = "searchDropdownBox" )
	public WebElement SearchBox;
	
	@FindBy(xpath ="//div//span[@id='nav-search-label-id1']") 
	 public WebElement DefectdropdownValue;
	
	
	@FindBy(xpath = "//a[@data-csa-c-slot-id=\"nav_cs_10\"]") 
	public WebElement homeAndKitchen;
	
	@FindBy(xpath = "//a[@data-csa-c-slot-id=\"nav_cs_6\"]")
	
	public WebElement electronics;
	
	@FindBy(xpath = "//a[@data-csa-c-slot-id=\"nav_cs_11\"]")
	public WebElement fashions;
	
	public HomePage()
	{
		actionObj = new Action();
		initElements();
	}

	public void initElements()
	{
		PageFactory.initElements(BaseClass.getDriver(),this);
	}

	public void defaultValueOfDropdown()
	{
		findElement(getDriver(), dropdownValue);
	}
	
    public void dropdownInterface()
    {
    	click(getDriver(), dropdownlist);
    }
   
    public void dropdownScroll()
    {
    	click(getDriver(), dropdownlist);
    	scrollByVisibility(getDriver(), DefectdropdownValue);
    	
    }
    
    public void VerifyHeaderAndDropdownEle()
    {
    	click(getDriver(), electronics);
    	findElement(getDriver(), dropdownValue);
    }
    
    public void VerifyHeaderAndDropdownHomeAndK() 
    { 
    	click(getDriver(), homeAndKitchen);
    	findElement(getDriver(), dropdownValue);
    } 
    
    public void VerifyHeaderAndDropdownFashion()
    {
    	moveToElement(getDriver(), fashions);
    	click(getDriver(), fashions);
    	findElement(getDriver(), dropdownValue);
    }

	public void VerifyGiftCardsFromDropdown()
	{
		click(getDriver(), dropdownlist);
		selectByIndex(SearchBox, 19);
	}
    
	public void VerifyBooksFromDropdown()
	{
		click(getDriver(), dropdownlist);
		selectByIndex(SearchBox, 11);
	}
	
	public void VerifyComputersAndAccessoriesFromDropdown()
	{
		click(getDriver(), dropdownlist);
		selectByIndex(SearchBox, 15);
	}
	
	public void DefectTest()
	{
		click(getDriver(), DefectdropdownValue);
		scrollByVisibility(getDriver(), DefectdropdownValue);
	}
	
}

