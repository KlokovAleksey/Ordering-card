package ru.netology;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebitCardTest {


    @Test
    void shouldSubmitForm() {

        open("http://localhost:9999");
        $("[type=text]").setValue("Иванов-Петров Иван");
        $("[type=tel]").setValue("+79005555555");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldInvalidValuesName() {
        open("http://localhost:9999");
        $("[type=text]").setValue("Ivan Ivanov");
        $("[type=tel]").setValue("+79005555555");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=name].input_invalid .input__inner .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldInvalidValuesPhone() {
        open("http://localhost:9999");
        $("[type=text]").setValue("Иван Иванов");
        $("[type=tel]").setValue("петров");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=phone].input_invalid .input__inner .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldEmptyName() {
        open("http://localhost:9999");
        $("[type=text]").setValue("");
        $("[type=tel]").setValue("+79005555555");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=name].input_invalid .input__inner .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldEmptyPhone() {
        open("http://localhost:9999");
        $("[type=text]").setValue("Иван Иванов");
        $("[type=tel]").setValue("");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=phone].input_invalid .input__inner .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldEmptyCheckBox() {
        open("http://localhost:9999");
        $("[type=text]").setValue("Иван Иванов");
        $("[type=tel]").setValue("+79005555555");
        $("[type=button]").click();
        $("[role=presentation").shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
    }

    @Test
    void shouldEmptyCheckBoxColor() {
        open("http://localhost:9999");
        $("[type=text]").setValue("Иван Иванов");
        $("[type=tel]").setValue("+79005555555");
        $("[type=button]").click();
        String actual = $("[role=presentation").getCssValue("color");
        String expected = "rgba(255, 92, 92, 1)";
        assertEquals(expected, actual);
    }

}