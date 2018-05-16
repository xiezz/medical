package com.xie.work.domain;

import javax.persistence.*;

@Entity
@Table(name = "team_user", schema = "platform", catalog = "")
public class TeamUserEntity {
    private Long teamId;
    private Long userId;
    private Integer leader;
    private String role;

    @Id
    @Column(name = "team_id")
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Basic
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "leader")
    public Integer getLeader() {
        return leader;
    }

    public void setLeader(Integer leader) {
        this.leader = leader;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamUserEntity that = (TeamUserEntity) o;

        if (teamId != null ? !teamId.equals(that.teamId) : that.teamId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (leader != null ? !leader.equals(that.leader) : that.leader != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teamId != null ? teamId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (leader != null ? leader.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
