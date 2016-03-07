/*
 * Copyright (c) 2015-2016, Index Data
 * All rights reserved.
 * See the file LICENSE for details.
 */
package raml;

import guru.nidi.ramltester.RamlDefinition;
import guru.nidi.ramltester.RamlLoaders;
import guru.nidi.ramltester.core.RamlReport;
import guru.nidi.ramltester.core.RamlValidator;
import guru.nidi.ramltester.core.Validation;
import static guru.nidi.ramltester.junit.RamlMatchers.validates;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RamlTest {
  public RamlTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testOkapiRaml() {
    RamlDefinition api = RamlLoaders.fromFile("src/main/raml").load("okapi.raml");

    // Don't check Validation.DESCRIPTION
    RamlValidator v = api.validator().withChecks(Validation.URI_PARAMETER, Validation.PARAMETER, Validation.EMPTY);

    Assert.assertThat(v.validate(), validates());
  }
}