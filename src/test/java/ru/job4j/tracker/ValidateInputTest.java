package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

        @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        List<String> answers = new ArrayList<>();
        answers.add("one");
        answers.add("1");
        Input in = new StubInput(answers);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenCorrectInput() {
        Output out = new StubOutput();
        List<String> answers = new ArrayList<>();
        answers.add("1");
        Input in = new StubInput(answers);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenMultipleCorrectInput() {
        Output out = new StubOutput();
        List<String> answers = new ArrayList<>();
        answers.add("1");
        answers.add("2");
        answers.add("3");
        Input in = new StubInput(answers);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
    }

        @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        List<String> answers = new ArrayList<>();
        answers.add("-1");
        Input in = new StubInput(answers);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
            assertThat(selected).isEqualTo(-1);
    }
}