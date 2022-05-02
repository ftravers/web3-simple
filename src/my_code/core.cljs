(ns my-code.core
  (:require
   [reagent.dom :as rdom]
   [goog.dom :as gdom]
   [cljsjs.web3]
   [cljs-web3.core :as web3]))

(defonce w3
  (web3/create-web3 "https://bsc-dataseed.binance.org/"))

(def data (atom {:nodes [{:node-url "https://bsc-dataseed.binance.org/"
                          :name "Binance Smart Chain RPC"}]
                 :wallets [{:nick-name "some router"
                            :id "0x95A9bd206aE52C4BA8EecFc93d18EACDd41C88CC"}
                           {:nick-name "another router"
                            :id "0xcdd95e8738edc0733583ee484a3050a05ee87ff5"}]}))

(defn get-balance [account-id]
  (get-balance account-id w3))

(defn ui []
  [:div
   [:div
    (for [item (-> @data :wallets)]
      ^{:key item}
      [:div
       [:div (str "balance: " (get-balance (:id item)))]
       [:div (str "Nick Name: " (:nick-name item))]])]])

(rdom/render ui (gdom/getElement "app"))
