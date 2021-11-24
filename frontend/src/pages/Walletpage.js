import WalletOverview from "../components/WalletOverview";
import useWalletBalances from "../hooks/useWalletBalances";


export default function Walletpage(){
    const {wallet} = useWalletBalances()

    return (
      <>
        <WalletOverview wallet={wallet}/>
      </>
    )
}