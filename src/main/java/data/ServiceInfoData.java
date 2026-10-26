package data;

import enums.ServiceType;

public sealed interface ServiceInfoData permits MarriageInfoData, BirthInfoData, DeathInfoData {
        ServiceType getServiceType();
}

