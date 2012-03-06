package net.vidageek.games.regex.task;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

final public class EscaperTest {

	@Test
	public void shouldTransformSpaceToSpaceDemarcation() {
		assertEquals("-Espa&ccedil;o-", new Escaper().apply(" "));
	}

	@Test
	public void shouldTransformEmptyStringToEmptyDemarcation() {
		assertEquals("-Vazio-", new Escaper().apply(""));
	}

}