(ns crucible.template
  (:require [crucible.template-key :refer [->key]]
            [crucible.resources :refer [encode-resource]]
            [crucible.parameters :refer [encode-parameter]]
            [crucible.outputs :refer [encode-output]]))

(defn- encode-template-element
  [template encode [k v]]
  [(->key k) (encode template v)])

(defn- encode-elements
  [template-map type-label encode-type-fn]
  [(->key type-label)
   (into {} (->> template-map
                 type-label
                 seq
                 (map (partial encode-template-element template-map encode-type-fn))))])

(defn make-template
  [element-map]
  (reduce (fn [acc [k v]] (if (seq v) (assoc acc k v) acc))
          {}
          [["AWSTemplateFormatVersion" "2010-09-09"]
           (encode-elements element-map :parameters encode-parameter)
           (encode-elements element-map :resources encode-resource)
           (encode-elements element-map :outputs encode-output)]))
