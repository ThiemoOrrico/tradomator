import {useEffect, useState} from "react";
import {getWallet} from "../service/binance-wallet-service";


export default  function useWalletBalances(){
    const [wallet, setWallet] = useState({})

    const getWalletBalance = () =>{
        getWallet()
            .then(setWallet)
            .catch(console.error)
    }

    useEffect( () => {
        getWalletBalance()
    }, [])



    return { wallet,setWallet, getWalletBalances: getWalletBalance}
}
