package magicGame.models.magicians;

import magicGame.models.magics.Magic;

import static magicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician {

    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        this.isAlive = isAlive();
        setMagic(magic);
    }


    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0){
            throw new  IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }
            this.health = health;
    }

    private void setProtection(int protection) {
        if (protection < 0){
            throw new  IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    private void setMagic(Magic magic) {
        if (magic == null){
            throw new NullPointerException(INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    @Override
    public boolean isAlive() {
        if (health>0){
            return true;
        }else {
        return false;
        }
    }

    @Override
    public void takeDamage(int points) {
        if (protection>=points){
            this.protection-=points;
        } else {
            int currentHealth = (protection+health) - points;
            if (currentHealth>0){
                this.protection = 0;
                this.health = currentHealth;
            }else {
                this.protection=0;
                this.health = 0;
            }
        }

    }




//    BlackWidow: magicianPeter
//Health: 0
//Protection: 0
//Magic: Luna


    @Override
    public String toString() {
        return String.format("%s: %s%nHealth: %d%nProtection: %d%nMagic: %s%n",
                getClass().getSimpleName(),username,health,protection,magic.getName());
    }
}
