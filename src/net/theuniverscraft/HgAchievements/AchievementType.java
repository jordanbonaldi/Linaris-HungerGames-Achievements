package net.theuniverscraft.HgAchievements;

public enum AchievementType {
	// LEVEL
	 KILLER("Tueur", new int[] { 50, 200, 500, 1000, 1500 },  new int[] { 50,150,200,400,1200 }, 0),
	 WINNER("Vainqueur", new int[] { 1, 5, 20, 30, 40 }, new int[] { 50,100,150,200,250 }, 1),
	 SPEEDER("Coureur", new int[] { 1000, 2500, 5000, 10000, 15000 },  new int[] { 50,100,150,200,250 }, 2),
	 
	 // AU PIF
	 BOW_KILL("Tuer à l'arc 5 fois", 5, 70),
	 BREAK_IRON("Miner 50 minerais de fer", 50, 100),
	 KILL_FIRST_ENNEMIE("Tuer votre premier ennemi", 1, 50),
	 WIN_FIRST("Gagner votre première partie", 1, 30),
	 USE_MINEUR("Utiliser le kit mineur", 1, 30),
	 USE_FLINT_AND_STEEL("Utiliser un briquet", 1, 20),
	 USE_ENDERPEARLS("Utiliser 5 enderpearls", 5, 50),
	 IRON_AXE_KILL("Tuer avec une hache en fer", 1, 100),
	 BURN_ENNEMIE("Brûler 5 ennemis", 5, 50),
	 BREAK_LOG("Récolter 80 buches de bois", 80, 100),
	 FIND_MAGIC_CHEST("Trouver 2 coffres magique", 2, 200),
	 BECOME_VIP("Acheter le status vip", 1, 500),
	 KILL_COW("Tuer 4 vaches", 4, 60),
	 DOUBLE_KILL("Faire 2 doubles kills", 2, 50),
	 EAT_GOLDEN_APPLE("Manger votre première pomme en or", 1, 30),
	 BREAK_COAL("Miner 20 minerais de charbons", 20, 50),
	 MAKE_IRON_ARMOR("Crafter un plastron en fer", 1, 50),
	 END_JUMP_LOBBY("Finir le jump du lobby HungerGames", 1, 100),
	 IRON_SWORD_KILL("Tuer 30 ennemis avec une épée en fer", 30, 200),
	 WOOD_SWORD_KILL("Tuer 10 ennemis avec une épée en bois", 10, 200);
	
	
	private String m_name = "";
	private int[] m_actions;
	private int[] m_points;
	private int m_line;
	AchievementType(String name, int[] actions, int[] points, int line){
		m_name = name;
		m_actions = actions;
		m_points = points;
		m_line = line;
	}
	
	AchievementType(String name, int actions, int points){
		this(name, new int[] { actions }, new int[] { points }, -1);
	}
	
	public String getName() { return m_name; }
	
	public boolean hasLevels() {
		return m_actions.length > 1;
	}
	
	public int getNbLevel() {
		return m_actions.length;
	}
	
	public int getActionLevel(int level) {
		level--;
		if(level >= m_actions.length) return m_actions[m_actions.length - 1];
		else if(level < 0) return m_actions[0];
		return m_actions[level];
	}
	
	public int getPoints(int level) {
		level--;
		if(level >= m_points.length) return m_points[m_points.length - 1];
		else if(level < 0) return m_points[0];
		return m_points[level];
	}
	
	public int getLevel(int actions) {
		for(int i = m_actions.length - 1; i >= 0; i--) {
			if(actions >= m_actions[i]) return i + 1;
		}
		return 0;
	}
	
	public int getLine() {
		return m_line;
	}
}
