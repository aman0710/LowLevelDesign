package LLDofSplitWise.Group;

import LLDofSplitWise.User.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {

    List<Group> groupList;

    public GroupController() {
        this.groupList = new ArrayList<>();
    }

    public void createNewGroup(String id, String name, User createdByUser) {
        Group group = new Group(id, name);
        group.addMember(createdByUser);
        this.groupList.add(group);
    }

    public Group getGroup(String id) {
        for(Group group: this.groupList) {
            if(group.getId().equalsIgnoreCase(id))
                return group;
        }
        return null;
    }
}
