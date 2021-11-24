import {useEffect, useState} from "react";
import {getWallet} from "../service/binance-wallet-service";


export default  function useWalletBalances(){
    const [wallet, setWallet] = useState({})

    const getWalletBalances = () =>{
        getWallet()
            .then(setWallet)
            .catch(console.error)
    }

    useEffect( () => {
        getWalletBalances()
    }, [])



    return { wallet,setWallet, getWalletBalances}
}
