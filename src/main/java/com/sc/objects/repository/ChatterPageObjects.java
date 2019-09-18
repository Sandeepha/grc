package com.sc.objects.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatterPageObjects {


@FindBy(xpath = "//input[@value='Reject']")
public static List <WebElement> rejectBtn;

@FindBy(xpath = "//div[text()='Add comments to the approval history']/..//textarea")
public static WebElement textArea;

@FindBy(xpath = "//div[contains(@id,'overlay_buttons')] //input[@value='OK']")
public static WebElement okayBtn;

@FindBy(xpath="//input[@title='Approve']")
public static List<WebElement> acceptBtn;



}
