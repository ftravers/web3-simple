(ns my-code.core
  (:require
   [reagent.dom :as rdom]
   [goog.dom :as gdom]
   [cljsjs.web3]
   [cljs-web3.core :as web3]))

(def wallet-2 "0x95A9bd206aE52C4BA8EecFc93d18EACDd41C88CC")

(def w3 (web3/create-web3 "https://bsc-dataseed.binance.org/"))

(defn getBalance [account-id web-3]
  (.fromWei web-3 (.getBalance (. web-3 -eth) account-id)))

(defn ui []
  [:div
   [:p (str "Wallet ID: " wallet-2)]
   [:p (str "Balance: " (getBalance wallet-2 w3))]])

(rdom/render ui (gdom/getElement "app"))
