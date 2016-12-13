package ru.stqa.pft.addressbook.model;
import com.google.common.collect.ForwardingSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Work on 20.11.2016.
 */
public class Groups extends ForwardingSet<GroupData> {

  private Set<GroupData> delegate;

  public Groups (Groups groups){
    this.delegate = new HashSet<GroupData>(groups.delegate);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Groups groups = (Groups) o;

    return delegate != null ? delegate.equals(groups.delegate) : groups.delegate == null;

  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (delegate != null ? delegate.hashCode() : 0);
    return result;
  }

  public Groups() {
    this.delegate = new HashSet<GroupData>();
  }

  @Override
  protected Set<GroupData> delegate() {
    return delegate;
  }

  public Groups withAdded (GroupData group){
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }

  public Groups without (GroupData group){
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }
}
