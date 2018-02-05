package com.mauriciotogneri.greencoffeeexample.test.features;

import android.support.test.rule.ActivityTestRule;

import com.mauriciotogneri.greencoffee.GreenCoffeeConfig;
import com.mauriciotogneri.greencoffee.GreenCoffeeTest;
import com.mauriciotogneri.greencoffee.Scenario;
import com.mauriciotogneri.greencoffee.ScenarioConfig;
import com.mauriciotogneri.greencoffeeexample.activities.LoginActivity;
import com.mauriciotogneri.greencoffeeexample.test.steps.ContactListSteps;
import com.mauriciotogneri.greencoffeeexample.test.steps.LoginSteps;
import com.mauriciotogneri.greencoffeeexample.test.steps.ScreenshotSteps;
import com.microsoft.appcenter.espresso.Factory;
import com.microsoft.appcenter.espresso.ReportHelper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.Locale;

import static com.mauriciotogneri.greencoffeeexample.test.TestSuite.ENGLISH;
import static com.mauriciotogneri.greencoffeeexample.test.TestSuite.SPANISH;

@RunWith(Parameterized.class)
public class LoginFeatureTest extends GreenCoffeeTest
{
    @Rule
    public ActivityTestRule<LoginActivity> activity = new ActivityTestRule<>(LoginActivity.class);

    public LoginFeatureTest(ScenarioConfig scenarioConfig)
    {
        super(scenarioConfig);
    }

    @Rule
    public ReportHelper reportHelper = Factory.getReportHelper();


    @Parameters(name = "{index} {0}")
    public static Iterable<ScenarioConfig> scenarios() throws IOException
    {
        return new GreenCoffeeConfig("testapp")
                .withFeatureFromAssets("assets/login.feature")
                .scenarios(ENGLISH);
    }

    @Test
    public void test()
    {
        start(new LoginSteps(), new ContactListSteps(), new ScreenshotSteps());
    }

    @Override
    protected void afterScenarioEnds(Scenario scenario, Locale locale)
    {
        reportHelper.label(String.format("afterScenarioEnds: %s.", scenario.name()));
    }
}