package org.example.DTO;

import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserPermissionDTO {
    private Integer uid;
    private String uname;
    private List<RoleInfo> roles;
    private List<PermissionInfo> permissions;

    @Data
    public static class RoleInfo {
        private Integer rid;
        private String rname;
    }

    @Data
    public static class PermissionInfo {
        private Integer pid;
        private String pname;
        private String url;
    }
    public void displayUserInfo() {
        String roleNames = roles.stream()
                .map(RoleInfo::getRname)
                .collect(Collectors.joining("、"));
        System.out.println(uname + "是" + roleNames);
        if (permissions != null && !permissions.isEmpty()) {
            System.out.println("可操作菜单");
            for (PermissionInfo permission : permissions) {
                System.out.println("<a href='" + permission.getUrl() + "'>" + permission.getPname() + "</a>");
            }
        } else {
            System.out.println("该用户没有任何操作权限");
        }
    }

    /**
     * 返回格式化后的用户信息字符串
     */
    public String getFormattedUserInfo() {
        StringBuilder sb = new StringBuilder();

        String roleNames = roles.stream()
                .map(RoleInfo::getRname)
                .collect(Collectors.joining("、"));
        sb.append(uname).append("是").append(roleNames).append("\n");

        // 可操作菜单
        if (permissions != null && !permissions.isEmpty()) {
            sb.append("可操作菜单\n");
            for (PermissionInfo permission : permissions) {
                sb.append("<a href='").append(permission.getUrl())
                        .append("'>").append(permission.getPname()).append("</a>\n");
            }
        } else {
            sb.append("该用户没有任何操作权限\n");
        }

        return sb.toString();
    }
}