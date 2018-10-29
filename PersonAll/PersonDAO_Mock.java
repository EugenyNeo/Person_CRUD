package PersonAll;

import java.util.ArrayList;

public class PersonDAO_Mock implements PersonDAO
{
	ArrayList<Person> lst = new ArrayList<Person>();
	public static ArrayList<Person> pp;
	public static ArrayList<Person> init()
	{
		pp = new ArrayList<Person>();

		pp.add(new Person(10, "Евдоким", "Платунов", 22));
		pp.add(new Person(12, "Дональт", "Жданов", 27));
		pp.add(new Person(21, "Валерий", "Голованов", 31));
		pp.add(new Person(44, "Антуан", "Жириновский", 44));
		pp.add(new Person(24, "Макс", "Зайцев", 45));
		pp.add(new Person(37, "Семён", "Сидоров", 32));
		pp.add(new Person(48, "Лев",  "Никонов", 68));
		pp.add(new Person(57, "Геннадий", "Щербаков", 52));
		pp.add(new Person(82, "Денис", "Зимин", 76));
		pp.add(new Person(97, "Ждан", "Давыдов", 34));
		//		
		pp.add(new Person(22, "Инесса", "Калинина", 21));
		pp.add(new Person(23, "Болеслава", "Панфилова",67));
		pp.add(new Person(43, "Лилия", "Силина", 25));
		pp.add(new Person(51, "Ева", "Игнатова", 69));
		pp.add(new Person(53, "Настасья", "Кулакова", 37));
		pp.add(new Person(67, "Клеопатра", "Евдокимова", 37));
		pp.add(new Person(13, "Василина", "Жданова", 26));
		pp.add(new Person(104, "Эльвира", "Григорьева", 34));
		pp.add(new Person(98, "Влада", "Красильникова", 19));
		pp.add(new Person(25, "Флора", "Колесова", 29));
		//		
		pp.add(new Person(15, "Харитон", "Пестов", 57));
		pp.add(new Person(76, "Апостол", "Нестеров", 37));
		pp.add(new Person(63, "Харитон", "Ленин", 21));
		pp.add(new Person(58, "Иван", "Никитин", 64));
		pp.add(new Person(75, "Велимир", "Прохоров", 41));
		pp.add(new Person(53, "Глеб", "Носов", 49));
		pp.add(new Person(95, "Лаврентий", "Гуляев", 34));
		pp.add(new Person(35, "Моисей", "Логунов", 35));
		pp.add(new Person(27, "Давид", "Князев", 27));
		pp.add(new Person(91, "Вениамин", "Фадеев", 17));
		//	
		pp.add(new Person(19, "Василина", "Дроздова", 34));
		pp.add(new Person(43, "Селена", "Крылова", 43));
		pp.add(new Person(67, "Борислава", "Пахомова", 46));
		pp.add(new Person(88, "Алиса", "Субботина", 51));
		pp.add(new Person(62, "Анастасия", "Морозова", 53));
		pp.add(new Person(109, "Арина", "Логинова", 62));
		pp.add(new Person(86, "Ксения", "Воронцова", 72));
		pp.add(new Person(38, "Инесса", "Суханова", 24));
		pp.add(new Person(47, "Юнона", "Мухина", 44));
		pp.add(new Person(52, "Евгения", "Дроздова", 52));

		return pp;
	}

	public PersonDAO_Mock()
	{
		lst = init();
	}

	@Override
	public void create(Person p) 
	{
		lst.add( p );
	}

	@Override
	public ArrayList<Person> read() 
	{
		return lst;
	}

	@Override
	public void update(Person p) 
	{
		for (Person pp : lst)
		{
			if(pp.id == p.id)
			{
				pp.fname = p.fname;
				pp.lname = p.lname;
				pp.age = p.age;
			}
		}
	}

	@Override
	public void delete(Person p) 
	{
		int i = p.id ;
		for (Person pp : lst)
		{
			if(pp.id == p.id)
				i = lst.indexOf(pp);
		}
		lst.remove(i);		
	}

}
