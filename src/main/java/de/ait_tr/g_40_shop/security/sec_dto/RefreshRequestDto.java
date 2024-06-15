package de.ait_tr.g_40_shop.security.sec_dto;

import java.util.Objects;

public class RefreshRequestDto {

    private String refreshtoken;

    public String getRefreshtoken() {
        return refreshtoken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RefreshRequestDto that = (RefreshRequestDto) o;
        return Objects.equals(refreshtoken, that.refreshtoken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refreshtoken);
    }

    @Override
    public String toString() {
        return String.format("Refresh request: refresh token - %s", refreshtoken);
    }
}
