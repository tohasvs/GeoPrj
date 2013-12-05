package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import server.dbService.HibernateUtil;
import server.dbService.tables.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Антон
 * Date: 05.12.13
 * Time: 22:06
 * To change this template use File | Settings | File Templates.
 */
public class DBServiceTest {
    private String[] girls = new String []{"Авелина","Авиталь","Агата","Аглая","Агнесса","Агния","Ада","Аделина","Аделия","Аделя","Адиля","Адина","Адия","Адэлина","Азалия","Азиза","Аида","Аиша","Айгерим","Айгуль","Айдана","Айжан","Айзада","Айзиля","Айлана","Айлин","Айлина","Айна","Айназ","Айнара","Айнура","Айсана","Айсулу","Айсылу","Айша","Айя","Акбота","Акерке","Акмарал","Аксиния","Аксинья","Алана","Алевтина","Алекса","Александра","Александрина","Алексия","Алена","Алеся","Алика","Алима","Алина","Алиса","Алисия","Алиша","Алия","Алла","Алсу","Алтана","Алтынай","Алуа","Альбина","Альвина","Альмира","Альфия","Амалия","Амели","Амелия","Амилия","Амина","Аминат","Амира","Анаит","Анара","Анастасия","Ангелина","Анелия","Анель","Анеля","Анжела","Анжелика","Анжелина","Аниса","Анисия","Анисья","Анита","Анна","Антонина","Анфиса","Анэля","Аня","Аполинария","Аполлинария","Ариадна","Ариана","Арианна","Арина","Арсения","Ару","Аружан","Асель","Асем","Асия","Асмик","Ася","Аурика","Афина","Аэлита","Аяна","Аяулым","Бажена","Балауса","Балжан","Балнур","Белла","Богдана","Божена","Ботагоз","Валентина","Валерия","Ванесса","Варвара","Василина","Василиса","Венера","Вера","Вероника","Веста","Виктория","Вилена","Виола","Виолета","Виолетта","Вита","Виталина","Виталия","Влада","Владислава","Владлена","Газиза","Галина","Галия","Гаяне","Глафира","Глория","Гузаль","Гузель","Гульдана","Гульназ","Гульнара","Гульшат","Дайана","Далила","Дамира","Дана","Данара","Даная","Даниела","Даниэла","Даниэлла","Дания","Дарига","Дарина","Дария","Дарья","Даша","Даяна","Джамиля","Джессика","Джулия","Джульетта","Диана","Дилара","Дильназ","Диля","Диляра","Дина","Динара","Доминика","Ева","Евангелина","Евгения","Евдокия","Евелина","Екатерина","Елдана","Елена","Елизавета","Елисавета","Еркежан","Есения","Жайна","Жамиля","Жанайым","Жанар","Жанель","Жания","Жанна","Жансая","Жасмин","Жибек","Жулдыз","Залина","Залия","Замира","Зара","Зарема","Зарина","Зере","Зиля","Зинаида","Злата","Златослава","Зоя","Зульфия","Иванна","Иветта","Изабелла","Илана","Илария","Илина","Илона","Ильвина","Ильмира","Ильназ","Ильнара","Иляна","Инара","Инга","Индира","Инесса","Инжу","Инкар","Инна","Иоанна","Иоланта","Ира","Ирада","Ирина","Ия","Калерия","Камила","Камилла","Камиля","Капитолина","Карима","Карина","Каріна","Каролина","Катарина","Катерина","Катрин","Катя","Кира","Кириена","Кристина","Ксения","Ксенья","Куаныш","Куралай","Лада","Лала","Лана","Лариса","Латифа","Лаура","Лейла","Лейсан","Леля","Лена","Лера","Леся","Лея","Лиана","Лида","Лидия","Лизавета","Лика","Лилиана","Лилит","Лилия","Лиля","Лина","Линара","Линда","Лия","Лола","Лолита","Луиза","Лэйла","Люба","Любава","Любовь","Людмила","Ляля","Мадина","Майя","Малика","Маргарита","Марго","Мари","Мариам","Марианна","Марика","Марина","Мария","Марта","Маруся","Марфа","Марья","Марьям","Марьяна","Махаббат","Медина","Мелания","Меланья","Мелиса","Мелисса","Меруерт","Мила","Милада","Милана","Милания","Милена","Милина","Милла","Милослава","Миляуша","Мира","Мирослава","Мирра","Мишель","Мия","Моника","Муслима","Мэри","Мээрим","Нагима","Надежда","Надия","Назгуль","Назерке","Назира","Назым","Наиля","Наргиз","Наргиза","Насиба","Настасья","Натали","Наталия","Наталья","Нафиса","Нелли","Нигина","Ника","Николетта","Николина","Николь","Нина","Нино","Нонна","Нурай","Нурия","Нурсулу","Оксана","Олександра","Олена","Олеся","Оливия","Ольга","Оля","Павла","Патимат","Паулина","Пелагея","Перизат","Полина","Рада","Радмила","Раиля","Раиса","Раксана","Ралина","Рамиля","Рамина","Рания","Раяна","Регина","Рената","Риана","Рианна","Римма","Рина","Рината","Рита","Роза","Розалина","Розалия","Роксана","Роксолана","Рузанна","Румия","Русалина","Руслана","Руфина","Сабина","Сабира","Сабрина","Саида","Салима","Салтанат","Самина","Самира","Сандра","Сания","Сара","Сафина","Сафия","Светлана","Святослава","Сева","Севинч","Сема","Серафима","Ситора","Снежана","Снежанна","Соня","Софи","София","Софья","Станислава","Стелла","Стефани","Стефания","Сусанна","Сымбат","Сюзанна","Таисия","Таисья","Тамара","Тамила","Таня","Татьяна","Тахмина","Тереза","Тогжан","Толганай","Томирис","Тоня","Ульяна","Устинья","Фаина","Фарида","Фариза","Фатима","Хадиджа","Хадижа","Христина","Шахноза","Шолпан","Шугыла","Шынар","Ыкылас","Эвелина","Эвилина","Эвита","Элана","Элен","Элеонора","Элиза","Элизабет","Элина","Элиф","Элла","Эллада","Эллина","Элона","Эльвина","Эльвира","Эльза","Эльмира","Эльнара","Эмили","Эмилия","Эмма","Энже","Эрика","Эсмира","Юлиана","Юлия","Юля","Юстина","Яна","Янина","Ярина","Ярослава","Ясмина"};
    private String[] boys = new String[]{"Аарон", "Абай", "Абдулла", "Абзал", "Абулхаир", "Абылай", "Адам", "Адилет", "Адиль", "Адият", "Адриан", "Ажар", "Азамат", "Азат", "Азиз", "Азизбек", "Азим", "Айару", "Айбар", "Айбек", "Айгиз", "Айдай", "Айдан", "Айдар", "Айдос", "Айдын", "Айзат", "Айнур", "Айрат", "Айшат", "Акбар", "Акжан", "Акжол", "Аким", "Акмаль", "Алан", "Алдар", "Алдияр", "Алекс", "Александр", "Алексей", "Алем", "Ален", "Али", "Алик", "Алим", "Алихан", "Алишер", "Алмаз", "Алмас", "Алмат", "Альберт", "Альмир", "Альтаир", "Альфред", "Амаль", "Аман", "Амиль", "Амин", "Амир", "Амиран", "Амирхан", "Анатолий", "Анвар", "Андрей", "Ансар", "Антон", "Ануар", "Арай", "Арайлым", "Арам", "Ардак", "Арзу", "Ариет", "Аристарх", "Аркадий", "Арлан", "Арман", "Армен", "Арнур", "Арсен", "Арсений", "Арсентий", "Арслан", "Артём", "Артемий", "Артур", "Архип", "Арыстан", "Асет", "Аскар", "Аслан", "Асхат", "Афанасий", "Ахмад", "Ахмед", "Ахмет", "Ашот", "Аяз", "Аян", "Аянат", "Батыр", "Бауыржан", "Бахтияр", "Бекболат", "Бекзат", "Бексултан", "Богдан", "Борис", "Борислав", "Бронислав", "Булат", "Вадим", "Валентин", "Валерий", "Валерик", "Василий", "Вениамин", "Вика", "Виктор", "Вильдан", "Виталий", "Владеслав", "Владимир", "Владислав", "Влас", "Всеволод", "Вячеслав", "Габриэль", "Гавриил", "Гаджи", "Гаухар", "Геворг", "Геннадий", "Георгий", "Герман", "Глеб", "Гордей", "Григорий", "Гульмира", "Давид", "Давлат", "Давыд", "Далер", "Дамиан", "Дамиль", "Дамир", "Данель", "Даниал", "Даниел", "Даниель", "Даниил", "Данил", "Данила", "Данило", "Даниль", "Данис", "Даниэл", "Даниэль", "Даниял", "Данияр", "Дарий", "Дархан", "Дарын", "Дарьяна", "Дастан", "Даулет", "Даурен", "Даян", "Дементий", "Демид", "Демьян", "Дени", "Дениз", "Денис", "Джамал", "Джамиль", "Диас", "Дидар", "Димитрий", "Динар", "Динислам", "Динияр", "Дионис", "Дияр", "Дмитрий", "Добрыня", "Доминик", "Досжан", "Дулат", "Дэвид", "Дэниз", "Евгений", "Евсей", "Егор", "Елизар", "Елисей", "Елнур", "Ерасыл", "Ерболат", "Еремей", "Ержан", "Ерлан", "Ермек", "Ернар", "Ерофей", "Ефим", "Ефрем", "Жан", "Жангир", "Жандос", "", "Жанибек", "Зангар", "Заур", "Захар", "Захарий", "Зуфар", "Ибрагим", "Ибрахим", "Иван", "Игнат", "Игнатий", "Игорь", "Идрис", "Илиан", "Илия", "Илларион", "Ильгам", "Ильгар", "Ильгиз", "Ильдар", "Ильмир", "Ильнар", "Ильнур", "Ильсур", "Ильфат", "Ильхам", "Ильшат", "Илья", "Ильяс", "Имран", "Иннокентий", "Инсаф", "Иоанн", "Иосиф", "Ираклий", "Иса", "Искандар", "Искандер", "Ислам", "Исмаил", "Кайрат", "Кайсар", "Камиль", "Канат", "Карен", "Карим", "Каусар", "Кевин", "Керим", "Ким", "Кирилл", "Клим", "Климентий", "Константан", "Константин", "Коркем", "Кристиан", "Кузьма", "Лаврентий", "Лев", "Леван", "Левон", "Ленар", "Лео", "Леон", "Леонард", "Леонид", "Лука", "Лукас", "Лукьян", "Любомир", "Ляйсан", "Магомед", "Мадияр", "Майкл", "Макар", "Макс", "Максат", "Максим", "Максимилиан", "Малик", "Мансур", "Марат", "Марк", "Маркус", "Марсель", "Мартин", "Матвей", "Матфей", "Микаил", "Микаэль", "Милан", "Милолика", "Мирас", "Мирон", "Мирослав", "Митя", "Михаил", "Михаэль", "Мстислав", "Мурад", "Мурат", "Муса", "Муслим", "Мустафа", "Мухаммад", "Мухаммед", "Надир", "Назар", "Назарий", "Наиль", "Нариман", "Натан", "Наташа", "Наум", "Нестор", "Ник", "Никита", "Никола", "Николай", "Николас", "Никон", "Нияз", "Нургали", "Нуржан", "Нурислам", "Нурлан", "Нурлыбек", "Нурсултан", "Олег", "Олжас", "Омар", "Орест", "Орхан", "Оскар", "Осман", "Остап", "Павел", "Петр", "Платон", "Прохор", "Равиль", "Радик", "Радим", "Радислав", "Радмир", "Радомир", "Раиль", "Райнур", "Райхан", "Рамазан", "Рамзан", "Рамиль", "Рамис", "Ранель", "Ранис", "Расим", "Растислав", "Расул", "Ратмир", "Рауан", "Рауль", "Рауф", "Раушан", "Рафаэль", "Рахат", "Рахим", "Рахман", "Рашид", "Раян", "Реналь", "Ренат", "Ризван", "Ринат", "Рифат", "Рихард", "Ричард", "Ришат", "Рияз", "Роберт", "Родион", "Ролан", "Роман", "Ростислав", "Рубен", "Рудольф", "Рузаль", "Руслан", "Рустам", "Рустем", "Рушан", "Сабир", "Савва", "Савелий", "Саид", "Салават", "Салим", "Салих", "Самат", "Самвел", "Самир", "Самуил", "Санжар", "Сармат", "Саян", "Саят", "Светозар", "Святогор", "Святослав", "Севастьян", "Семен", "Серафим", "Сергей", "Спартак", "Станислав", "Степан", "Стефан", "Сулейман", "Султан", "Сурен", "Тагир", "Таир", "Талгат", "Тамерлан", "Тамир", "Тамирлан", "Тарас", "Тахир", "Теймур", "Темирлан", "Темур", "Тигран", "Тимерлан", "Тимофей", "Тимур", "Тихон", "Трофим", "Улан", "Умар", "Усман", "Фадей", "Фарид", "Фарис", "Фархад", "Федор", "Феликс", "Фидан", "Филипп", "Хаким", "Хамза", "Хасан", "Хусейн", "Чингиз", "Чингис", "Шамиль", "Эдвард", "Эдгар", "Эдем", "Эдуард", "Элиана", "Эльдар", "Эльмар", "Эльмир", "Эмиль", "Эмин", "Эмир", "Эрвин", "Эрик", "Эрнест", "Юлиан", "Юлий", "Юнус", "Юра", "Юрий", "Юсуф", "Яков", "Ян", "Янис", "Яромир", "Ярослав", "Ясин", "Ясмин"};

    private Random random;
    private final int limit = 1000;
    private int k = 0;

    // DB
    private Session session;


    @org.junit.Before
    public void setUp() throws Exception {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        random = new Random();
    }

    @Test
    public void createUsers() {
        Location loc1 = getRandomLocation();

        List<Location> locations = new ArrayList<Location>();
        locations.add(loc1);

        User user1 = new User();
        String [] arr = random.nextInt(2) == 0 ? girls: boys;
        String name = arr[random.nextInt(arr.length - 1)];
        user1.setName(name);
        user1.setPassword("dzrwqmsadDJNKnd2ie2d3Ddsd");
        user1.setGender(random.nextInt(20) + 5);
        user1.setToken("vk");
        user1.setExist(true);
        user1.setExpires(System.currentTimeMillis() / 1000L);
        user1.setPhoto("abc.png");
        user1.setLocations(locations);

        session.save(user1);
        session.getTransaction().commit();
    }

    @Test
    public void getUser() {
        Query query = session.createQuery("from User user where user.id = 5020");
        List<User> list = query.list();
        User user = list.get(0);
        System.out.println(user.getId() + " : " + user.getLocations());
        session.getTransaction().commit();
    }

    @Test
    public void createMessanger() {
        User rUser = getRandomUser();

        Integer maxDialog = (Integer) session.createQuery("select max(dialog.dialogId) from Dialog dialog").list().get(0);
        Query query2 = session.createQuery("from Dialog dialog where dialog.dialogId = :maxDialog");
        query2.setParameter("maxDialog", random.nextInt(maxDialog));
        Dialog rDialog = (Dialog) query2.list().get(0);

        Messanger messanger = new Messanger();
        messanger.setDialog(rDialog);
        messanger.setUser(rUser);
        messanger.setMsg("Hello World!");
        messanger.setDateTime(new Date());
        messanger.setRead(false);
        session.save(messanger);
        session.getTransaction().commit();
    }

    @Test
    public void createDialog() {
        User user1 = getRandomUser();
        User user2 = getRandomUser();

        String [] arr = random.nextInt(2) == 0 ? girls: boys;
        String title = arr[random.nextInt(arr.length - 1)];

        Dialog dialog = new Dialog();
        dialog.setTitle(title);

        user1.getDialogs().add(dialog);
        user2.getDialogs().add(dialog);

        session.update(user1);
        session.update(user2);

        session.getTransaction().commit();
    }

    @Test
    public void createNewUserLocation() {
        User user1 = getRandomUser();

        Location loc = new Location();
        loc.setLatitude((random.nextFloat() * 100) % 180);
        loc.setLongitude((random.nextFloat() * 100) % 180);
        loc.setTime(new Date());

        user1.getLocations().add(loc);
        session.update(user1);

        session.getTransaction().commit();
    }

    @Test
    public void createMeet() {
        User user = getRandomUser();

        Location loc = new Location();
        loc.setLatitude((random.nextFloat() * 100) % 180);
        loc.setLongitude((random.nextFloat() * 100) % 180);
        loc.setTime(new Date());

        Wall wall = new Wall();
        wall.setMsg("Wall msg");
        wall.setDateTime(new Date());

        Meet meet = new Meet();
        meet.setAdmin(user);
        meet.setTitle("Meet1");
        meet.setDescription("Go to cinema");
        meet.setPhoto("abc.png");
        meet.setDateTime(new Date());
        meet.setAccess(Access.PUBLIC);
        meet.setStatus("Status");
        meet.setLastUpdate(new Date());
        meet.setWhatChange("Wall");
        meet.setType(1);
        meet.setWall(wall);
        meet.setLocation(loc);

        session.save(meet);
        session.getTransaction().commit();
    }

    @Test
    public void addParticipants() {
        User user = getRandomUser();
        Meet meet = getRandomMeet();

        Participants participant = new Participants();
        participant.setMeet(meet);
        participant.setUser(user);
        participant.setLastUpdate(new Date());

        session.save(participant);
        session.getTransaction().commit();
    }

    @Test
    public void createFriends() {

    }

    @Test
    public void createPlace() {
        Wall wall = new Wall();
        wall.setMsg("Wall msg");
        wall.setDateTime(new Date());

        Location loc = getRandomLocation();
        User user = getRandomUser();

        Place place = new Place();
        place.setLocation(loc);
        place.setWall(wall);
        place.setUser(user);
        place.setTitle("Title1");
        place.setDescription("Desc1");
        place.setStatus("Status1");
        place.setImage("top.png");

        session.save(place);
        session.getTransaction().commit();
    }

    private User getRandomUser() {
        Integer userId1 = random.nextInt((Integer) session.createQuery("select max(user.id) from User user").list().get(0));
        User user = (User) session.createQuery("from User user where user.id = :user_id")
                .setParameter("user_id", userId1).list().get(0);
        return user;
    }

    private Meet getRandomMeet() {
        Integer meetId = random.nextInt((Integer) session.createQuery("select max(meet.id) from Meet meet").list().get(0));
        Meet meet = (Meet) session.createQuery("from Meet meet where meet.id = :meet_id")
                .setParameter("meet_id", meetId).list().get(0);
        return meet;
    }

    private Location getRandomLocation() {
        Location loc = new Location();
        loc.setLatitude((random.nextFloat() * 100) % 180);
        loc.setLongitude((random.nextFloat() * 100) % 180);
        loc.setTime(new Date());
        return  loc;
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }
}