from abc import ABCMeta, abstractmethod
import abc

class IWalker():
    __metaclass__ = ABCMeta

    @abstractmethod
    def walk(self, s: str):
        """"walk..."""

class IEater():
    __metaclass__ = ABCMeta

    @abstractmethod
    def walk(self, s: str):
        """"eat..."""

class Humman(IWalker, IEater):
    def walk(self, s):
        pass

    def eat(self, s):
        pass


class Shape(abc.ABC):
    _type: str
    def area(self): pass

class Circle(Shape):
    radius: int
    def area(self): pass