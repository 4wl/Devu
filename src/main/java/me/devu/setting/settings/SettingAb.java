package me.devu.setting.settings;

public abstract class SettingAb {
    private final String name;
    private final Boolean[] visible;

    public SettingAb(String name) {
        this.name = name;
        this.visible = null;
    }

    public SettingAb(String name, Boolean ... visible) {
        this.name = name;
        this.visible = visible;
    }

    public String getName() {
        return this.name;
    }

    public boolean isVisible() {
        if (this.visible == null) {
            return true;
        }
        for (Boolean visible : this.visible) {
            if (visible.booleanValue()) continue;
            return false;
        }
        return true;
    }
}