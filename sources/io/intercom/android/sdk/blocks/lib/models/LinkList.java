package io.intercom.android.sdk.blocks.lib.models;

import android.os.Parcel;
import android.os.Parcelable;
import io.intercom.android.sdk.blocks.lib.models.Link;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkList implements Parcelable {
    public static final Parcelable.Creator<LinkList> CREATOR = new Parcelable.Creator<LinkList>() {
        public LinkList createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Link.class.getClassLoader());
            return new LinkList(arrayList, (Link) parcel.readParcelable(Link.class.getClassLoader()));
        }

        public LinkList[] newArray(int i) {
            return new LinkList[i];
        }
    };
    private final Link footerLink;
    private final List<Link> links;

    public int describeContents() {
        return 0;
    }

    public LinkList(List<Link> list, Link link) {
        this.links = list;
        this.footerLink = link;
    }

    public static LinkList fromBlock(Block block) {
        if (block == null) {
            return new LinkList(Collections.emptyList(), new Link.Builder().build());
        }
        return new LinkList(block.getLinks(), block.getFooterLink());
    }

    public List<Link> getLinks() {
        return this.links;
    }

    public Link getFooterLink() {
        return this.footerLink;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LinkList linkList = (LinkList) obj;
        if (!this.links.equals(linkList.links)) {
            return false;
        }
        return this.footerLink.equals(linkList.footerLink);
    }

    public int hashCode() {
        return (this.links.hashCode() * 31) + this.footerLink.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.links);
        parcel.writeParcelable(this.footerLink, i);
    }
}
