# Автоматизированное тестирование формы заказа карты:

Требования к содержимому полей:

* Поле Фамилия и имя - разрешены только русские буквы, дефисы и пробелы.
* Поле телефон - только цифры (11 цифр), символ + (на первом месте).
* Флажок согласия должен быть выставлен.

Тестируемая функциональность: отправка формы.

<img width="513" alt="order2" src="https://user-images.githubusercontent.com/68289203/118326155-40b8fe80-b50d-11eb-94d4-c1481ac12e54.png">


Условия: если все поля заполнены корректно, то вы получаете сообщение об успешно отправленной заявке:

<img width="517" alt="success" src="https://user-images.githubusercontent.com/68289203/118326118-2bdc6b00-b50d-11eb-831c-ee8c694c5bea.png">


# [![Build status](https://ci.appveyor.com/api/projects/status/ug02tej3wtm4xxr2?svg=true)](https://ci.appveyor.com/project/KlokovAleksey/ordering-card)
