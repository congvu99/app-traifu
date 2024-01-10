package com.trainerfu.story;

public class SectionPartDefinition {
    private SectionPartBinder partBinder;
    private Class<? extends SectionPartView> partViewClass;

    public SectionPartDefinition(Class<? extends SectionPartView> cls, SectionPartBinder sectionPartBinder) {
        this.partViewClass = cls;
        this.partBinder = sectionPartBinder;
    }

    public Class<? extends SectionPartView> getPartViewClass() {
        return this.partViewClass;
    }

    public SectionPartBinder getPartBinder() {
        return this.partBinder;
    }
}
