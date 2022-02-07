package me.devu.setting.settings;

public class NumberSetting
        extends SettingAb {
    private Number value;
    public final Number min;
    public final Number max;

    public NumberSetting(String name, Number value, Number min, Number max) {
        super(name);
        this.value = value;
        this.min = min;
        this.max = max;
    }

    public NumberSetting(String name, Number value, Number min, Number max, Boolean ... visible) {
        super(name, visible);
        this.value = value;
        this.min = min;
        this.max = max;
    }

    public Number getValue() {
        return this.value;
    }

    public void setValue(Number number) {
        this.value = this.value;
    }
}