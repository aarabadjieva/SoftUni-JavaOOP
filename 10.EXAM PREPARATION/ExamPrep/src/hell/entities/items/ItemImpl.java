package hell.entities.items;

import hell.interfaces.Item;

public abstract class ItemImpl implements Item {

    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointsBonus;
    private int damageBonus;

    protected ItemImpl(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
            this.setName(name);
            this.setStrengthBonus(strengthBonus);
            this.setAgilityBonus(agilityBonus);
            this.setIntelligenceBonus(intelligenceBonus);
            this.setHitPointsBonus(hitPointsBonus);
            this.setDamageBonus(damageBonus);
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    protected void setAgilityBonus(int agilityBonus) {
        this.agilityBonus = agilityBonus;
    }

    protected void setIntelligenceBonus(int intelligenceBonus) {
        this.intelligenceBonus = intelligenceBonus;
    }

    protected void setHitPointsBonus(int hitPointsBonus) {
        this.hitPointsBonus = hitPointsBonus;
    }

    protected void setDamageBonus(int damageBonus) {
        this.damageBonus = damageBonus;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthBonus() {
        return this.strengthBonus;
    }

    @Override
    public int getAgilityBonus() {
        return this.agilityBonus;
    }

    @Override
    public int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    @Override
    public int getHitPointsBonus() {
        return this.hitPointsBonus;
    }

    @Override
    public int getDamageBonus() {
        return this.damageBonus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("###Item: ").append(this.getName())
                .append(System.lineSeparator())
                .append("###+").append(this.getStrengthBonus())
                .append(" Strength")
                .append(System.lineSeparator())
                .append("###+").append(this.getAgilityBonus())
                .append(" Agility")
                .append(System.lineSeparator())
                .append("###+").append(this.getIntelligenceBonus())
                .append(" Intelligence")
                .append(System.lineSeparator())
                .append("###+").append(this.getHitPointsBonus())
                .append(" HitPoints")
                .append(System.lineSeparator())
                .append("###+").append(this.getDamageBonus())
                .append(" Damage");
        return sb.toString();
    }
}
