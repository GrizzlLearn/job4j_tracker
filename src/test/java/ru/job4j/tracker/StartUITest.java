package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new ArrayList<>() {{
                    add("0");
                    add("Item name");
                    add("1");
                }}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("new item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new ArrayList<>(Arrays.asList("0", String.valueOf(item.getId()), replacedName, "1"))
        );
        List<UserAction> actions = Arrays.asList(
                new ReplaceAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("deleted item"));
        Input in = new StubInput(
                new ArrayList<>(Arrays.asList("0", String.valueOf(item.getId()), "1"))
        );
        List<UserAction> actions = Arrays.asList(
                new DeleteAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(in, memTracker, actions);
        assertNull(memTracker.findById(item.getId()));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new ArrayList<>(Arrays.asList("0", String.valueOf(one.getId()), replaceName, "1"))
        );
        List<UserAction> actions = Arrays.asList(
                new ReplaceAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Replace item" + ln
                        + "1. Exit" + ln
                        + "=== Replace item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Replace item" + ln
                        + "1. Exit" + ln
                        + "=== Exit ===" + ln
        ));
    }

    @Test
    public void whenShowAllItemsTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Input in = new StubInput(
                new ArrayList<>(Arrays.asList("0", "1"))
        );
        List<UserAction> actions = Arrays.asList(
                new FindAllAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find all Items" + ln
                        + "1. Exit" + ln
                        + "=== Find all items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find all Items" + ln
                        + "1. Exit" + ln
                        + "=== Exit ===" + ln
        ));
    }

    @Test
    public void whenFindItemByNameTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Input in = new StubInput(
                new ArrayList<>(Arrays.asList("0", one.getName(), "1"))
        );
        List<UserAction> actions = Arrays.asList(
                new FindByNameAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit" + ln
                        + "=== Find item by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit" + ln
                        + "=== Exit ===" + ln
        ));
    }

    @Test
    public void whenFindItemByNameTestOutputIsFailed() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Item two = new Item("test2");
        Input in = new StubInput(
                new ArrayList<>(Arrays.asList("0", two.getName(), "1"))
        );
        List<UserAction> actions = Arrays.asList(
                new FindByNameAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit" + ln
                        + "=== Find item by name ===" + ln
                        + "Заявки с именем: " + two.getName() + " не найдены." + ln
                        + "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit" + ln
                        + "=== Exit ===" + ln
        ));
    }

    @Test
    public void whenFindItemByIdTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Input in = new StubInput(
                new ArrayList<>(Arrays.asList("0", String.valueOf(one.getId()), "1"))
        );
        List<UserAction> actions = Arrays.asList(
                new FindByIdAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "=== Exit ===" + ln
        ));
    }

    @Test
    public void whenFindItemByIdTestOutputIsFailed() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Item two = new Item("test2");
        Input in = new StubInput(
                new ArrayList<>(Arrays.asList("0", String.valueOf(two.getId()), "1"))
        );
        List<UserAction> actions = Arrays.asList(
                new FindByIdAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ===" + ln
                        + "Заявка с введенным id: " + two.getId() + " не найдена." + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "=== Exit ===" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new ArrayList<>(Arrays.asList("1", "0"))
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. Exit" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu:" + ln
                                + "0. Exit" + ln
                                + "=== Exit ===" + ln
                )
        );
    }
}
