package io.github.kurasey.wedding_invitation.model;

public enum ActionSource {
    ADMIN("Администратор"),
    GUEST("Гость");

    private final String displayName;

    ActionSource(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}