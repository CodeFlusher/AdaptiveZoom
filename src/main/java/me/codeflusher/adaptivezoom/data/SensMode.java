package me.codeflusher.adaptivezoom.data;

import net.minecraft.client.resources.I18n;

public class SensMode {

    private final ScrollPredicate predicate;
    private final String translateString;

    public SensMode(ScrollPredicate predicate, String translateString) {
        this.predicate = predicate;
        this.translateString = translateString;
    }

    public String getTranslated(){
        return I18n.format(this.translateString);
    }

    public ScrollPredicate getPredicate() {
        return predicate;
    }
}
