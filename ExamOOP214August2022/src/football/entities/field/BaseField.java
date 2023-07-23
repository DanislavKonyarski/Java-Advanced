package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field{

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        int sum = 0;
        for (Supplement supplement : supplements) {
            sum += supplement.getEnergy();
        }
        return sum;
    }

    @Override
    public void addPlayer(Player player) {
        if (players.size()>capacity){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        players.forEach(e-> e.stimulation());
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):",this.name,this.getClass().getSimpleName())).append(System.lineSeparator());
        sb.append("Player: ");
        if (players.isEmpty()){
            sb.append("none");
        }else {
            sb.append(this.players.stream().map(Player::getName).collect(Collectors.joining(" ")));
        }
        sb.append(System.lineSeparator());
        sb.append("Supplement: "+supplements.size()).append(System.lineSeparator());
        sb.append("Energy: "+sumEnergy());
        return String.valueOf(sb);
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
