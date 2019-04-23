(set-logic ALL)
(set-option :produce-models true)
(set-option :incremental true)
(set-option :block-models true)
(set-option :finite-model-find true)
(set-option :sets-ext true)
(declare-sort Atom 0)
(declare-sort UninterpretedInt 0)
(declare-fun atomUniverse () (Set (Tuple Atom)))
(declare-fun atomIdentity () (Set (Tuple Atom Atom)))
(declare-fun p () (Set (Tuple Atom)))
(declare-fun a () (Set (Tuple Atom Atom)))
; Universe definition for Atoms
(assert (= atomUniverse (as univset (Set (Tuple Atom)))))
; Identity axiom 1 for Atoms
(assert (forall ((_x Atom)) (member (mkTuple _x _x) atomIdentity)))
; Identity axiom 2 for Atoms
(assert (forall ((_x Atom)(_y Atom)) (=> (member (mkTuple _x _y) atomIdentity) (= _x _y))))
; Main formula
(assert (not (= (intersection (join (union a (tclosure a)) (setminus atomUniverse (join (union (join a a) (tclosure (join a a))) (setminus atomUniverse p)))) (join (union a (tclosure a)) (setminus atomUniverse (join (union (join a a) (tclosure (join a a))) (setminus atomUniverse (setminus atomUniverse p)))))) (as emptyset (Set (Tuple Atom))))))
(check-sat)
(get-model)
