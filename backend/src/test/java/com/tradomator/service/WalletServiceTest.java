package com.tradomator.service;

import com.tradomator.model.Balance;
import com.tradomator.model.Wallet;
import com.tradomator.repo.WalletRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class WalletServiceTest {

    WalletRepo walletRepo = mock(WalletRepo.class);
    WalletService walletService = new WalletService(walletRepo);

    @Test
    @DisplayName("Test_should_Return_LatestWallet")
    void getLatestWalletDocumentTest_should_Return_LatestWallet(){

        //GIVEN
        Wallet walletTestDtoLatest = new Wallet();
        walletTestDtoLatest.setId("any ID created by DB");
        walletTestDtoLatest.setUpdateTime(54323);
        walletTestDtoLatest.setBalances(List.of(
                new Balance("BNB", "120.321", "0.0000"),
                new Balance("BTC", "10.21", "0.0000")));

        when(walletRepo.findTopByOrderByUpdateTimeDesc()).thenReturn(walletTestDtoLatest);

        //WHEN
        Wallet actual = walletService.getLatestWalletDocument();

        //THEN
        verify(walletRepo).findTopByOrderByUpdateTimeDesc();
        assertThat(actual, is(walletTestDtoLatest));
    }
}