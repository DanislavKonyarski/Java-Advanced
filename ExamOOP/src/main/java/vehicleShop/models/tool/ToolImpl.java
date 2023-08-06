package vehicleShop.models.tool;

import static vehicleShop.common.ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO;

public class ToolImpl implements Tool {
    private int power;

    public ToolImpl(int power) {
        setPower(power);
    }

    private void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void decreasesPower() {
        power = power - 5;
        if (power<0){
            power=0;
        }

    }

    @Override
    public boolean isUnfit() {
        if (power>0){
            return true;
        }
        return false;
    }
}
