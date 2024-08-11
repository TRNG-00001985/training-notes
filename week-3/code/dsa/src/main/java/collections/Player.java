package collections;

public class Player implements Comparable<Player>{
	
	private int id;
	private String name;
	private int ranking;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", ranking=" + ranking + ", age=" + age + "]";
	}
	public Player(int id, String name, int ranking, int age) {
		super();
		this.id = id;
		this.name = name;
		this.ranking = ranking;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.getName());
	}

}
